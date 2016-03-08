package org.play.test.helpers

import java.io.InputStream
import java.security.cert.X509Certificate

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.StreamConverters
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration._

object Tools {

  class ReqHeader(
                           override val id: Long = 1L,
                           override val tags: Map[String, String] = Map.empty,
                           override val uri: String = "",
                           override val path: String = "",
                           override val method: String = "GET",
                           override val version: String = "1",
                           override val queryString: Map[String, Seq[String]] = Map.empty,
                           override val headers: Headers = Headers.apply(),
                           override val remoteAddress: String = "",
                           override val secure: Boolean = false,
                           override val clientCertificateChain: Option[Seq[X509Certificate]] = None) extends RequestHeader {
  }

  def convertStreamToString(is: java.io.InputStream) : String = {
    val s = new java.util.Scanner(is).useDelimiter("\\A")
    if (s.hasNext()) s.next() else ""
  }

  def getBody(result: Future[Result], duration: FiniteDuration = 5.seconds): String = {
    implicit val system = ActorSystem("flowtest")
    implicit val mater = ActorMaterializer()

    val stream = Await.result(result, duration).body.dataStream.runWith(StreamConverters.asInputStream(duration))
    convertStreamToString(stream)
  }

  implicit class BodyExtractor(action: Action[AnyContent]) {
    def body: String = getBody(action.apply(null))
  }
}