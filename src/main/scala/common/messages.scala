package common

case class Word(word: String, title: String)
case class Content(text: String, title: String)
case class Reduce(name: String, x : List[String])
case object Flush
case object Done
