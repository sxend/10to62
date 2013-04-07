import arimitsu.sf.Convert62Decimal.encode
import arimitsu.sf.Convert62Decimal.decode

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 21:50
 */
object Test {

	def main(args: Array[String]): Unit = {
//		println(encode(0))
//		println(encode(1))
//		println(encode(5))
//		println(encode(10))
//		println(encode(15))
//		println(encode(63))
		println(encode(64))
		println(Long.MaxValue + ":" + encode(Long.MaxValue))
		println(Int.MaxValue + ":" + encode(Int.MaxValue))
		println("encode end")
//		println(decode("0"))
//		println(decode("1"))
//		println(decode("5"))
//		println(decode("a"))
//		println(decode("f"))
//		println(decode("11"))
		println(decode("12"))
		println("aZl8N0y58I7 :" + decode("aZl8N0y58I7"))
		println("2lkCB1 :" + decode("2lkCB1"))
	}
}
