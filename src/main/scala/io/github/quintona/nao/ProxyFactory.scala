package io.github.quintona.nao

import com.aldebaran.proxy._

object ProxyFactory {
  System.loadLibrary("jnaoqi")
  val NAO_IP = "10.0.0.50"
  val NAO_PORT = 9559

  def speech = new ALTextToSpeechProxy(NAO_IP, NAO_PORT)
  def sonar = new ALSonarProxy(NAO_IP, NAO_PORT)
  def memory = new ALMemoryProxy(NAO_IP, NAO_PORT)
  def posture = new ALRobotPostureProxy(NAO_IP, NAO_PORT)
  def motion = new ALMotionProxy(NAO_IP, NAO_PORT)
  def navigation = new ALNavigationProxy(NAO_IP, NAO_PORT)
  def behavior = new ALBehaviorManagerProxy(NAO_IP, NAO_PORT)
  def leds = new ALLedsProxy(NAO_IP, NAO_PORT)
}
