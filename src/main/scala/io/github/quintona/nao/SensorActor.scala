package io.github.quintona.nao

import akka.actor._ 
import scala.concurrent.duration._

case class Subscribe
case class Unsubscribe
case class SonarDetected(left: Float, right: Float)
 

object SensorActor{
  def props(tollerance: Float = 0.1f): Props = Props(new SensorActor(tollerance))
}

class SensorActor(tollerance: Float) extends Actor with ActorLogging {
  import Implicits._
  import context._

  val sonar = ProxyFactory.sonar
  val memory = ProxyFactory.memory 
  val leftKey = "Device/SubDeviceList/US/Left/Sensor/Value"
  val rightKey = "Device/SubDeviceList/US/Right/Sensor/Value"
  val Tick = "Tick"

  var scheduler:Option[Cancellable]  = None
  var currentLeft = 0.0f
  var currentRight = 0.0f

  def receive = {
    case Tick => {
      val left: Float = memory.getData(leftKey) 
      val right: Float = memory.getData(rightKey) 
      var change = false
      if(Math.abs(left - currentLeft) > tollerance){
        currentLeft = left
        change = true
      }
      if(Math.abs(right - currentRight) > tollerance){ 
        currentRight = right
        change = true                                                  
      }      
      if(change) context.actorSelection("../*") ! SonarDetected(left, right)
    }
    case Subscribe => {
      sonar.subscribe("scala")
      scheduler = Some(context.system.scheduler.schedule(0 milliseconds,
                                            100 milliseconds,
                                            self,
                                            Tick))
    }
    case Unsubscribe => {
      scheduler match {
        case Some(s) if !s.isCancelled => s.cancel
      }
      sonar.unsubscribe("scala")
    }
  }
}
