package io.github.quintona.nao

import com.aldebaran.proxy._

object Implicits{
  implicit def motionToMotion(proxy: ALMotionProxy) = new Motion(proxy)
  implicit def variantToFloat(variant: Variant) = variant.toFloat
  implicit def variantToString(variant:Variant) = variant.getType match {
    case t:Variant.typeV if t.toString == "VFLOAT" => variant.toFloat.toString
    case t:Variant.typeV if t.toString == "VINT" => variant.toInt.toString
    case t:Variant.typeV if t.toString == "VBOOL" => variant.toBoolean.toString
    case t:Variant.typeV if t.toString == "VSTRING" => variant.toString
    case t:Variant.typeV if t.toString == "VCHARARRAY" => variant.toStringArray.toString
    case t:Variant.typeV if t.toString == "VFLOATARRAY" => variant.toFloatArray.toString
    case t:Variant.typeV if t.toString == "VARRAY" => "Text Representation Unsupported"
    case t:Variant.typeV if t.toString == "VINTARRAY" => variant.toIntArray.toString
    case t:Variant.typeV if t.toString == "VBINARY" => variant.toBinary.toString
    case _ => "TextRepresentation Unsupported"
  }
  implicit def variantToInt(variant: Variant) = variant.toInt
  implicit def variantToBool(variant: Variant):Boolean = variant.toBoolean
  

}
