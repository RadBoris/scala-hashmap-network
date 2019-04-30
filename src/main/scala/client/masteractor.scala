package client

import akka.actor.{Actor, ActorRef, Props, Address}
import akka.routing.{Broadcast, RoundRobinPool, ConsistentHashingPool}
import akka.routing.ConsistentHashingRouter.ConsistentHashMapping
import akka.remote.routing.{RemoteRouterConfig}

import com.typesafe.config.ConfigFactory

import common._

class MasterActor extends Actor {

  val numberMappers  = ConfigFactory.load.getInt("number-mappers")
  val numberReducers  = ConfigFactory.load.getInt("number-reducers")

  var pending = numberReducers

  val addresses = Seq (
    Address ("akka", "MapReduceClient"),
    Address("akka.tcp", "MapReduceServer", "127.0.0.1", 2552)
  )


  def hashMapping: ConsistentHashMapping = {
    case Word (word, title) => word
  }

  val reduceActors = context.actorOf(RemoteRouterConfig(ConsistentHashingPool(numberReducers, hashMapping = hashMapping), addresses)
    .props(Props[ReduceActor]))


  val mapActors = context.actorOf(RemoteRouterConfig(RoundRobinPool(numberMappers), addresses)
    .props(Props(classOf[MapActor], reduceActors)))

  def receive = {
    case Content (name, title) =>
      mapActors ! Content (name, title)

    case Flush =>
      mapActors ! Broadcast(Flush)
    case Done =>
      pending -= 1
      if (pending == 0)
        context.system.terminate
  }
}
