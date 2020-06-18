package ps

class Plaindrome {
    // https://leetcode.com/problems/longest-palindromic-substring/
    /***
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Example 2:

    Input: "cbbd"
    Output: "bb"
     */
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var start = 0
        var end = 0
        s.indices.forEach {
            val lenOfOdd = getPalindromeLength(s, it, it)
            val lenOfEven = getPalindromeLength(s, it, it + 1)
            val longerOne = lenOfOdd.coerceAtLeast(lenOfEven)
            if (longerOne > end - start) {
                start = it - (longerOne - 1) / 2
                end = it + longerOne / 2
            }
        }
        return s.substring(start, end + 1)
    }

    private fun getPalindromeLength(s: String, start: Int, end: Int): Int {
        var sIndex = start
        var eIndex = end
        while (sIndex >= 0 && eIndex < s.length && s[sIndex] == s[eIndex]) {
            sIndex--
            eIndex++
        }
        return eIndex - sIndex - 1
    }
}