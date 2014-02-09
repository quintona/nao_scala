
:power
vals.isettings.maxPrintString = 100
export DYLD_LIBRARY_PATH=/Users/quintonanderson/workspace/qiws/naoqi-sdk-1.14.5-mac64/lib/

import io.github.quintona.nao._
import io.github.quintona.nao.Implicits._

//general
val memory = ProxyFactory.memory

//speech
val speech = ProxyFactory.speech
speech.say("HAHAHA!")

//sonar
val sonar = ProxyFactory.sonar
sonar.subscribe("scala")
val f: Float = memory.getData("Device/SubDeviceList/US/Left/Sensor/Value")
sonar.unsubscribe("scala")

//motion
val posture = ProxyFactory.posture
val motion = ProxyFactory.motion
val navigation = ProxyFactory.navigation
//x,y,theta
navigation.moveTo(1.0f,0.0f,0.0f)
motion.wakeUp
motion.rest
motion.stiffnessInterpolation("Body", 1.0f, 1.0f)//on
motion.stiffnessInterpolation("Body", 0.0f, 1.0f)//off
motion.getSummary
//Crouch, LyingBack, LyingBelly, Sit, SitRelax, Stand, StandInit, StandZero
posture.goToPosture("Stand", 1.0f) 
posture.goToPosture("Sit", 1.0f) 
motion.openHand("RHand")
motion.closeHand("RHand")


//behavior
val behavior = ProxyFactory.behavior
behavior.getInstalledBehaviors()
behavior.getRunningBehaviors()
behavior.isBehaviorRunning("taiDance")
behavior.runBehavior("taiDance")
behavior.stopBehavior("taiDance")

def checkSonar = for(i <- 1 to 10){
  val f1:Float = memory.getData("Device/SubDeviceList/US/Left/Sensor/Value")
  val f2:Float = memory.getData("Device/SubDeviceList/US/Right/Sensor/Value") 
  println("Sensor Data: " + f1 + " and " + f2)
  Thread.sleep(1000)
} 
