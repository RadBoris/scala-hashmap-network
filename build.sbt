lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.8",
  scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation"),
  resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.22",
)

lazy val root = (project in file(".")).
  aggregate(common, server, client)

lazy val server = (project in file("server")).
  settings(commonSettings: _*).
  settings(
  name := "Server"
)

lazy val common = (project in file("common")).
  settings(commonSettings: _*).
  settings(
  name := "Common"
)

lazy val client = (project in file("client")).
  settings(commonSettings: _*).
  settings(
  name := "Client"
)
