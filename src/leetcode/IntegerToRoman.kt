package leetcode

class IntegerToRoman {
    // https://leetcode.com/problems/integer-to-roman/

    fun intToRoman(num: Int): String {
        if (num < 1 || num > 3999) throw IllegalArgumentException()

        var numToConvert = num
        var divider = 1000
        val str = StringBuilder()
        while (numToConvert > 0) {
            val first = numToConvert / divider
            if (first > 0) {
                when (divider) {
                    1000 -> {
                        for (i in 0 until first) str.append("M")
                    }
                    100 -> {
                        str.append(getRoman(first, "C", "D", "M"))
                    }
                    10 -> {
                        str.append(getRoman(first, "X", "L", "C"))
                    }
                    else -> {
                        str.append(getRoman(first, "I", "V", "X"))
                    }
                }
            }
            numToConvert %= divider
            divider /= 10
        }

        return str.toString()
    }

    private fun getRoman(first: Int, one: String, five: String, ten: String): StringBuilder {
        val str = StringBuilder()
        if (first == 9) str.append(one).append(ten)
        else if (first == 4) str.append(one).append(five)
        else {
            if (first in 5..8) {
                str.append(five)
                for (i in 0 until first - 5) str.append(one)
            } else {
                for (i in 0 until first) str.append(one)
            }
        }
        return str
    }
}
