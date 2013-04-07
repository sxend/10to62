package arimitsu.sf

import annotation.tailrec
import runtime.RichLong

/**
 * User: sxend
 * Date: 13/04/07
 * Time: 15:17
 */
object Convert62Decimal {
	private val chars: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	private val radix:Long = 62
	@tailrec
	def encode(num: Long, s: String = ""): String = {
		if (num == 0) {
			return if (s.length == 0) "0" else s
		}
		encode(Math.floor(num / radix) toLong, chars.charAt((num % radix).toInt) + s)
	}

	@tailrec
	def decode(s: String, index: Int = 0, num: Long = 0): Long = {
		if (s.length <= index) {
			return num
		}
		decode(s, index + 1, num + chars.indexOf(s.reverse.charAt(index)) * Math.pow(radix,index).toLong)
	}

}
