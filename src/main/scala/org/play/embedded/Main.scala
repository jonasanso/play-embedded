package org.play.embedded

import play.api.mvc._
import play.api.routing.sird._
import play.core.server.NettyServer

object Main {
  def main(args: Array[String]) {
    NettyServer.fromRouter() {
      case GET(p"/echo/$x") => Action {
        Results.Ok(s"Echo: $x")
      }
    }
  }
}
