import sbt._
import Process._
import Keys._
import sbt.plugins.JvmPlugin


lazy val root = (project in file(".")).

settings (
  name := "MapReduceEngine",
  version := "1.0",
  scalaVersion := "2.12.8",
  scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation"),
  resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.22",
  libraryDependencies +=  "com.typesafe.akka" %% "akka-remote" % "2.5.22",
)


// lazy val plugin = (project in file("plugin")).
// settings(
// 	 name := "MapReducePlugin" ,
//      mainClass in (Compile, run) := Some("org.radboris.sbt.MapReducePlugin")
// )//.enablePlugins(sbtPlugins)

// lazy val MapReducePlugin = (project in file("map-reduce"))

// lazy val myRunTask = inputKey[Unit]("A custom run task.")

// fullRunInputTask(myRunTask, Test, "foo.Foo", "arg1", "arg2")
