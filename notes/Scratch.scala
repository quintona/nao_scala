
export DYLD_LIBRARY_PATH=/Users/quintonanderson/workspace/qiws/naoqi-sdk-1.14.5-mac64/lib/

:load notes/Init.scala
:load notes/InitProxies.scala

//speech
speech.say("Scala is awesome, for a JVM thing")

//sonar
sonar.subscribe("scala")
val f: Float = memory.getData("Device/SubDeviceList/US/Left/Sensor/Value")
sonar.unsubscribe("scala")

//motion
//x,y,theta
navigation.moveTo(1.0f,0.0f,0.0f)
motion.wakeUp
motion.rest
//motion.stiffnessInterpolation("Body", 1.0f, 1.0f)//on
//motion.stiffnessInterpolation("Body", 0.0f, 1.0f)//off
motion.getSummary
//Crouch, LyingBack, LyingBelly, Sit, SitRelax, Stand, StandInit, StandZero
posture.goToPosture("Stand", 1.0f) 
posture.goToPosture("Sit", 1.0f) 
motion.openRightHand
motion.closeRightHand


//behavior
behavior.getInstalledBehaviors()
behavior.getRunningBehaviors()
behavior.isBehaviorRunning("taiDance")
behavior.runBehavior("taiDance")
behavior.stopBehavior("taiDance")

// Here are the actor startup details:
val sensorActor = system.actorOf(SensorActor.props(0.1f), "sensor-actor")
sensorActor ! Subscribe
sensorActor ! Unsubscribe
val listener = system.actorOf(DistanceFlicker.props, "flicker")

//LEDs
leds.off("FaceLeds") 
leds.on("FaceLeds")

val f = for{
  f1 <- Future{navigation.moveTo(1.0f, 0.0f, 0.0f)}.mapTo[Boolean]
  f2 <- Future{if(f1)navigation.moveTo(0.0f, 1.0f, 0.0f) else false}.mapTo[Boolean]
  f3 <- Future{if(f2)navigation.moveTo(-1.0f, 0.0f, 0.0f) else false}.mapTo[Boolean]
} yield f3
 
val result = Await.result(f, 2 minutes)

val b = navigation.moveTo(1.0f, 0.0f, 0.0f)  




