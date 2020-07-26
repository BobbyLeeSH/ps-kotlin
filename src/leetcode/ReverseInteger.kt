package leetcode

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
 */

class ReverseInteger {
    fun reverse(x: Int): Int {
        val isPositive = x >= 0
        val intString = if (isPositive) x.toString() else x.toString().substring(1)
        var reverse = 0
        intString.indices.forEach {
            try {
                reverse = Math.addExact(reverse, Math.multiplyExact(Character.getNumericValue(intString[it]), Math.pow(10.0, it.toDouble()).toInt()))
            } catch (e: ArithmeticException) {
                return 0
            }
        }
        return if (isPositive) reverse else reverse * -1
    }
}