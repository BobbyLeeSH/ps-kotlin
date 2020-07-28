package leetcode

class DivideTwoInteger {
    // https://leetcode.com/problems/divide-two-integers/

    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE
        return dividend / divisor
    }
}