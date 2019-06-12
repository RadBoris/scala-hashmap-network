package client

import akka.actor.{ActorSystem, Props}
import scala.io.Source
import com.typesafe.config.ConfigFactory
import common._

 object MapReduceClient extends App {
	val system = ActorSystem("MapReduceClient", ConfigFactory.load.getConfig("client"));
  	val master = system.actorOf(Props[MasterActor], name = "master")

	val content: Content = Content ("A Tale of Two Cities", "http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg98.txt")

	val content2: Content = Content ( "The Pickwick papers", "http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg580.txt")

	master ! content
	master ! content2
	master ! Flush
}
