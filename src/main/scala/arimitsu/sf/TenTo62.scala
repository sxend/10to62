package arimitsu.sf

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 15:17
 */
object TenTo62 {
	private val chars: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

	def convert(o: Long, s: String): String = {
		if (o <= 0) {
			return s
		}
		convert(Math.floor(o / 62) toLong, chars.charAt((o % 62) toInt) + s)
	}

	def convert(o: Long): String = {
		convert(o, "")
	}

	def main(args: Array[String]): Unit = {
		println(convert(0))
		println(convert(1))
		println(convert(5))
		println(convert(10))
		println(convert(15))
		println(convert(36))
		println(convert(Long.MaxValue))
	}
}
