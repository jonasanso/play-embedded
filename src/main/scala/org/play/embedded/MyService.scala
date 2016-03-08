package org.play.embedded

import play.api.mvc.{Action, AnyContent, RequestHeader, Results}
import play.api.routing.sird._


object MyService {

  val routes: PartialFunction[RequestHeader, Action[AnyContent]] = {
    case GET(p"/greeting" ? q_?"name=$name") => Action {
      Results.Ok(s"Hello ${name.getOrElse("World")}!")
    }
  }

}
