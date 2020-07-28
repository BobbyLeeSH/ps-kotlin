package leetcode

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        val size = needle.length
        for (i in 0 until  haystack.length - size) {
            if (haystack.substring(i, i+size) == needle) return i
        }
        return -1
    }
}