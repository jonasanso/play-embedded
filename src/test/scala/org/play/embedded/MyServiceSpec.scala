package org.play.embedded

import akka.actor.ActorSystem
import org.play.test.helpers.Tools._
import play.api.test.{FakeHeaders, FakeRequest, PlaySpecification}

class MyServiceSpec extends PlaySpecification {

  implicit val system = ActorSystem("test")

  "MyService" should {
    "return a greeting for GET requests to the greeting path" in {
      val requestHeader = FakeRequest(method = "GET", path = "/greeting")

      MyService.routes.apply(requestHeader).body must beEqualTo("Hello World!")
    }

    "return a greeting for GET requests to the greeting path with name parameter" in {
      val requestHeader = FakeRequest(method = "GET", uri = "/greeting?name=test", headers = FakeHeaders(), body = "")

      MyService.routes.apply(requestHeader).body must beEqualTo("Hello test!")

    }

    "leave GET requests to other paths unhandled" in {
      MyService.routes.isDefinedAt(FakeRequest(method = "GET", path = "/kermit")) must beFalse
    }

    "leave PUT request to greeting unhandled" in {
      MyService.routes.isDefinedAt(FakeRequest(method = "PUT", path = "/greeting")) must beFalse
    }
  }
}



