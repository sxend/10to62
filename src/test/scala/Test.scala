import arimitsu.sf.{Radix, RadixConversion}
import java.util.UUID

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 21:50
 */
object Test {

  def main(args: Array[String]): Unit = {
    println((Radix(10) --> 16)("10")) // a
  }
}
