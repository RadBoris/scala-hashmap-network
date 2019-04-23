package mapreduce

import scala.collection.mutable.{ HashMap, MultiMap, Set, MutableList}
import akka.actor.{Actor, ActorRef}
import com.typesafe.config.ConfigFactory

class ReduceActor extends Actor {
  var remainingMappers = ConfigFactory.load.getInt("number-mappers")
  //var reduceMap = new HashMap[String, List[String]]
    var reduceMap = scala.collection.mutable.Map[String, List[String]]()


  def receive = {
    case Word(name, title) =>
      if (!reduceMap.keySet.exists(_==name)) {
          val l = List(title)
              reduceMap.put(name, l)
          } else {
              println("FOUND")
              println(title)
              val n = reduceMap.get(name).get;
              val k = n :+ title
              println(reduceMap.get(name).get)
              reduceMap.update(name, k)
          }

    case Flush =>
      remainingMappers -= 1
      if (remainingMappers == 0) {
        println(self.path.toStringWithoutAddress + " : " + reduceMap)
        context.parent ! Done
      }
  }
}
