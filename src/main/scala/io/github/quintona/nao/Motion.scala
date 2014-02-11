package io.github.quintona.nao

import com.aldebaran.proxy.ALMotionProxy

class Motion(proxy: ALMotionProxy){

  val rightHand = "RHand"
  val leftHand = "LHand"

  def openRightHand = proxy.openHand(rightHand)
  def openLeftHand = proxy.openHand(leftHand)
  def closeRightHand = proxy.closeHand(rightHand)
  def closeLeftHand = proxy.closeHand(leftHand)

}
