
lazy val root = (project in file(".")).

settings (
  name := "MapReduceEngine",
  version := "1.0",
  scalaVersion := "2.12.8",
  scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation"),
  resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.22",
  libraryDependencies +=  "com.typesafe.akka" %% "akka-remote" % "2.5.22"
)

lazy val MapReducePlugin = (project in file("map-reduce"))

