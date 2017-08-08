name := "play-embedded"

organization := "org.play"

version := "0.0.1"

scalaVersion := "2.12.3"

cancelable in Global := true

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-netty-server" % "2.6.1",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.play" %% "play-specs2" % "2.6.1" % "test"
)

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "reference.conf" => MergeStrategy.concat
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
}