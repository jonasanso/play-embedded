# Play framework embedded

 Since play 2.4 you can run play embedded in you app.
 This allows for a very simple streamlined way to build your RESTful API.

# Demo
Just run
```
sbt "~ re-start"
```

Open http://localhost:9000/greeting in your browser

You can also try http://localhost:9000/greeting?name=User

Code changes are watched, application will restart automatically after every change.

# Create Uber JAR
Just run
```
sbt assembly
```

Size of the JAR 36MB

Run your server
```
java -jar target/scala-2.11/play-embedded-assembly-0.0.1.jar
```

# Run test
Just run
```
sbt test
```

# References
This example project was created after the meetup ran by Tamer Radi https://skillsmatter.com/skillscasts/7563-exploring-play-s-new-features

# Play documentation
https://www.playframework.com/documentation/2.4.x/ScalaEmbeddingPlay

https://www.playframework.com/documentation/2.4.x/ScalaSirdRouter

# Reloading

App restart after code changes is possible thanks to Spray SBT revolver

https://github.com/spray/sbt-revolver

# Notes
Make sure you run it with Java 8
