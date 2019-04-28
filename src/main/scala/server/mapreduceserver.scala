package server

import com.typesafe.config.ConfigFactory
import akka.actor.{Actor, ActorRef, Props}

import common._


object MapReduceApplication extends App {
	val system = ActorSystem("MapReduceServer", ConfigFactory.load.getConfig("server"));
}

