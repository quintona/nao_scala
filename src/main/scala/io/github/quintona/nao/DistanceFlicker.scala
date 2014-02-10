package io.github.quintona.nao

import akka.actor._

object DistanceFlicker{
  def props = Props(new DistanceFlicker) 
}

class DistanceFlicker extends Actor with ActorLogging {

  import Implicits._

  val leds = ProxyFactory.leds

  val prefix = "Face/Led"
  val suffix = "Actuator/Value"
  val eyes = List("Left", "Right")
  val degs = List("0Deg", "90Deg", "180Deg", "270Deg")
  val colors = List("Red", "Green", "Blue")
  val groups = colors.map(c => eyes.flatMap(e => degs.map(d => prefix + "/" + c + "/" + e + "/" + d + "/" + suffix))) 

  val greenThreshold = 1.0f
  val blueThreshold = 0.8f
  val redThreshold = 0.24f
  

  leds.createGroup("allRed", groups(0).toArray)
  leds.createGroup("allGreen", groups(1).toArray)
  leds.createGroup("allBlue", groups(2).toArray)
  leds.off("FaceLeds")

  def receive = {
    case sd:SonarDetected => {
      val av = (sd.left + sd.right) / 2
      if(av > blueThreshold) {
        leds.off("FaceLeds")
        leds.on("allGreen")
      }
      else if(av <= blueThreshold && av > redThreshold) {
        leds.off("FaceLeds")
        leds.on("allBlue")
      } else if(av <= redThreshold){
        leds.off("FaceLeds")
        leds.on("allRed")
      }
    }
  }
}
