package arimitsu.sf.example.radix

import arimitsu.sf.utils.Radix

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 21:50
 */
object UsageExample {

  def main(args: Array[String]): Unit = {

    val decimal = Radix(10)
    val decimalToHexDecimal = decimal --> 16

    println(decimalToHexDecimal("100")) // 64

    val decimalToBase36 = decimal --> 36
    println(decimalToBase36("100")) // 2s

    val decimalToBase62 = Radix(10) --> 62
    println(decimalToBase62("100")) // 1C

    val base62ToDecimal = Radix(62) --> 10
    println(base62ToDecimal("1C")) // 100

  }
}
