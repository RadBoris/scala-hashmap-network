package client

import akka.actor.{ActorSystem, Props}
import scala.io.Source
import com.typesafe.config.ConfigFactory
import common._

 object MapReduceClient extends App {
	val system = ActorSystem("MapReduceClient", ConfigFactory.load.getConfig("client"));
  	val master = system.actorOf(Props[MasterActor], name = "master")

	val content: Content = Content ("Title", "http://159.89.129.146/test/newtext.txt")

	master ! content
	master ! Flush
}
