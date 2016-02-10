name := "Play Embedded"

organization := "org.stackabletraits"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-netty-server" % "2.5.0-M2",
  "org.slf4j" % "slf4j-simple" % "1.7.14",
  "org.specs2" %% "specs2" % "2.4" % "test"
)

