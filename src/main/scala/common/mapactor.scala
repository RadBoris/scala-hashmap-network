package common

import scala.collection.mutable.HashSet
import akka.actor.{Actor, ActorRef}
import akka.remote.routing.{RemoteRouterConfig}
import akka.remote.RemoteActorRef
import akka.routing.Broadcast
import akka.remote.RemoteScope
import scala.io.Source
import org.radboris.sbt._

class MapActor(reduceActors: ActorRef) extends Actor {
  Thread sleep(2000)

  def receive = {
    case Content (title, url) =>
      val content: String = Source.fromURL(url).mkString

      content.replaceAll("""[\p{Punct}&&[^.]]""", "")

      // the plugin mapper
      MapData.mapper(title, content, reduceActors)
      case Flush =>
        reduceActors ! Broadcast(Flush)
  }
}
