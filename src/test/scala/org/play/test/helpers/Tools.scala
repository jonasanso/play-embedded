package org.play.test.helpers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.StreamConverters
import play.api.mvc._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object Tools {

  implicit class BodyExtractor(action: Action[AnyContent])(implicit system: ActorSystem) {
    implicit val mater = ActorMaterializer()

    def body: String = getBody(action.apply(null))

    private def getBody(result: Future[Result], duration: FiniteDuration = 5.seconds): String = {

      val stream = Await.result(result, duration).body.dataStream.runWith(StreamConverters.asInputStream(duration))
      convertStreamToString(stream)
    }

    private def convertStreamToString(is: java.io.InputStream) : String = {
      val s = new java.util.Scanner(is).useDelimiter("\\A")
      if (s.hasNext()) s.next() else ""
    }

  }
}