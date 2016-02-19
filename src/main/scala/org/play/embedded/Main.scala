package org.play.embedded

import java.util.concurrent.atomic.AtomicLong

import play.api.libs.json.Json
import play.api.mvc._
import play.api.routing.sird._
import play.core.server.NettyServer

object Main {
  case class Greetings(id: Long, content: String)

  object Greetings {
    val counter = new AtomicLong()

    def apply(content: String): Greetings = Greetings(counter.incrementAndGet(), content)

    implicit val writes = Json.writes[Greetings]
  }

  def main(args: Array[String]) {
    NettyServer.fromRouter() {
      case GET(p"/greeting" ? q_?"name=$name") => Action {
        val message = s"Hello ${name.getOrElse("World")}!"
        Results.Ok(Json.toJson(Greetings(message)))
      }
    }
  }
}

