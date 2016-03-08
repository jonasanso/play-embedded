package org.play.embedded

import org.play.test.helpers.Tools._
import play.api.test.PlaySpecification

class MyServiceSpec  extends PlaySpecification {


  "MyService" should {
    "return a greeting for GET requests to the greeting path" in {
      val requestHeader = new ReqHeader(method = "GET", path = "/greeting")

      MyService.routes.apply(requestHeader).body must beEqualTo("Hello World!")
    }

    "return a greeting for GET requests to the greeting path with name parameter" in {
      val requestHeader = new ReqHeader(method = "GET", path = "/greeting", queryString = Map("name" -> Seq("test")))

      MyService.routes.apply(requestHeader).body must beEqualTo("Hello test!")

    }

    "leave GET requests to other paths unhandled" in {
      MyService.routes.isDefinedAt(new ReqHeader(path = "/kermit")) must beFalse
    }

    "leave PUT request to greeting unhandled" in {
      MyService.routes.isDefinedAt(new ReqHeader(method = "PUT", path = "/greeting")) must beFalse
    }
  }
}



