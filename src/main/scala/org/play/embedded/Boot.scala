package org.play.embedded

import play.core.server.NettyServer

object Boot {
  def main(args: Array[String]) {
    NettyServer.fromRouter() (MyService.routes)
  }
}

