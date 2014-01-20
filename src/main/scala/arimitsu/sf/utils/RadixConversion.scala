package arimitsu.sf.utils

import annotation.tailrec

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 15:17
 */
private[sf] object RadixConversion {
  private[this] lazy val CHARS: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
  private[this] lazy val MAX_RADIX = CHARS.length

  private[sf] def apply(radix: Long): RadixConversion = {
    if (radix > MAX_RADIX) {
      throw new IllegalArgumentException("radix too large")
    } else if (radix <= 1) {
      throw new IllegalArgumentException("radix too small")
    }
    new RadixConversion(radix, CHARS)
  }

}

private[sf] class RadixConversion(val radix: Long, private val chars: String) {
  private[sf] def encode(num: Long): String = encode(num, "")

  private[sf] def decode(str: String): Long = decode(str, 0, 0)

  @tailrec
  private def encode(num: Long, str: String): String = {
    if (num == 0) {
      return if (str.length == 0) "0" else str
    }
    encode(Math.floor(num / radix) toLong, chars.charAt((num % radix) toInt) + str)
  }

  @tailrec
  private def decode(str: String, index: Int, num: Long): Long = {
    if (str.length <= index) {
      return num
    }
    decode(str, index + 1, num + chars.indexOf(str.reverse.charAt(index)) * Math.pow(radix, index) toLong)
  }

}

object Radix {
  def apply(from: Long) = new Radix(from)
}

private[sf] class Radix(private val from: Long) {
  def -->(to: Long) = {
    lazy val fromRadix = RadixConversion(from)
    lazy val toRadix = RadixConversion(to)
    (number: String) => toRadix.encode(fromRadix.decode(number))
  }
}