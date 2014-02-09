package io.github.quintona.nao

import com.aldebaran.proxy._

class VariantWrapp(variant:Variant){

//  override def toString = "NAV"

  override def toString : String = {
    println(variant.getType.swigValue)
    variant.getType match {
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
  }
}
