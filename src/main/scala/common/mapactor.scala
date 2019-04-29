package common

import akka.actor.{Actor, ActorRef}
import akka.routing.Broadcast

class MapActor(reduceActor: ActorRef) extends Actor {

  val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    "do", "go", "if", "in", "is", "it", "of", "on", "the", "to")

  def receive = {
    case Content (text, title) =>
      process(text, title)
    case Flush =>
        reduceActor ! Broadcast(Flush)
  }

  def process(content: String, title: String) = {
    content.replaceAll("""[\p{Punct}&&[^.]]""", "")
    for (word <- content.split("[\\p{Punct}\\s]+"))
      if ((!STOP_WORDS_LIST.contains(word)) && word.exists(_.isUpper)) {
	       reduceActor ! Word(word, title)
      }
  }
}
