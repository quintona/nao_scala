

import io.github.quintona.nao._ 
import io.github.quintona.nao.Implicits._

import akka.actor.{ActorSystem, Props} 
import scala.concurrent._
import scala.concurrent.duration._
implicit val system = ActorSystem("nao")
implicit val executionContext = system.dispatcher
