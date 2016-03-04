name := "play-embedded"

organization := "org.play"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-netty-server" % "2.5.0",
  "org.slf4j" % "slf4j-simple" % "1.7.14",
  "org.specs2" %% "specs2" % "2.4" % "test"
)

// META-INF discarding
assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "reference.conf" => MergeStrategy.concat
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
}