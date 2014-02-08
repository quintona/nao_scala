package io.github.quintona.nao

import com.aldebaran.proxy._

object ProxyFactory {
  System.loadLibrary("jnaoqi")
  val NAO_IP = "10.0.0.50"
  val NAO_PORT = 9559

  def speechProxy = {
    new ALTextToSpeechProxy(NAO_IP, NAO_PORT)
  }

  def sonarProxy = {
    new ALSonarProxy(NAO_IP, NAO_PORT)
  }

  def memory = {
    new ALMemoryProxy(NAO_IP, NAO_PORT)
  }
}
