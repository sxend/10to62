package arimitsu.sf

import annotation.tailrec
import runtime.RichLong

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 15:17
 */
object Convert62Decimal {
	val chars: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	val rokujuni:Long = 62
	@tailrec
	def encode(num: Long, s: String = ""): String = {
		if (num == 0) {
			return if (s.length == 0) "0" else s
		}
		encode(Math.floor(num / rokujuni) toLong, chars.charAt((num % rokujuni).toInt) + s)
	}

	@tailrec
	def decode(s: String, index: Int = 0, num: Long = 0): Long = {
		if (s.length <= index) {
			return num
		}
		decode(s, index + 1, num + chars.indexOf(s.reverse.charAt(index)) * Math.pow(rokujuni,index).toLong)
	}

}
