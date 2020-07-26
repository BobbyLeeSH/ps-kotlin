package leetcode

// https://leetcode.com/problems/palindrome-number/
/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val str = x.toString()
        for (i in 0 until str.length / 2) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}