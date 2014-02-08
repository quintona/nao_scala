package io.github.quintona.nao

import com.aldebaran.proxy.Variant

object Implicits{
  implicit def wrappVariant(variant: Variant) = new VariantWrapp(variant)
}
