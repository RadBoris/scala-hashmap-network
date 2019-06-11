package server

import com.typesafe.config.ConfigFactory
import akka.actor._
// import org.radboris.sbt._

import common._


object MapReduceApplication extends App {
	val system = ActorSystem("MapReduceServer", ConfigFactory.load.getConfig("server"));

	val t = Map;
	println(t.toString
	)
}

