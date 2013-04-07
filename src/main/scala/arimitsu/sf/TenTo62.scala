package arimitsu.sf

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 15:17
 */
object TenTo62 {
	private val chars: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

	private def convert(num: Long, s: String = ""): String = {
		if (num == 0) {
			return if (s.length == 0) "0" else s
		}
		convert(Math.floor(num / 62) toLong, chars.charAt((num % 62).toInt) + s)
	}

	def main(args: Array[String]): Unit = {
		println(convert(0))
		println(convert(1))
		println(convert(5))
		println(convert(10))
		println(convert(15))
		println(convert(36))
		println(Long.MaxValue + ":" + convert(Long.MaxValue))
	}
}
