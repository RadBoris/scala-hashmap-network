package common

import scala.collection.mutable.HashSet

import akka.actor.{Actor, ActorRef}
import akka.remote.routing.{RemoteRouterConfig}
import akka.remote.RemoteActorRef
import akka.routing.Broadcast
import akka.remote.RemoteScope

class MapActor(reduceActors: ActorRef) extends Actor {


  println(self.path)

  Thread sleep(2000)

  val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    "do", "go", "if", "in", "is", "it", "of", "on", "the", "to")

  def receive = {
    case Content (text, title) =>
      process(text, title)
    case Flush =>
        reduceActors ! Broadcast(Flush)
  }

  def process(content: String, title: String) = {
    content.replaceAll("""[\p{Punct}&&[^.]]""", "")
    for (word <- content.split("[\\p{Punct}\\s]+"))
      if ((!STOP_WORDS_LIST.contains(word)) && word.exists(_.isUpper)) {
	       reduceActors ! Word(word, title)
      }
  }
}
