name := "play-embedded"

organization := "org.play"

version := "0.0.1"

scalaVersion := "2.11.7"

cancelable in Global := true

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-netty-server" % "2.5.1",
  "org.slf4j" % "slf4j-simple" % "1.7.14",
  "com.typesafe.play" %% "play-specs2" % "2.5.1" % "test"
)

// META-INF discarding
assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "reference.conf" => MergeStrategy.concat
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
}