package ps

class LongestPrefix {
    //https://leetcode.com/problems/longest-common-prefix/

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var max = getPrefix(strs[0], strs[1])
        for (i in 2 until strs.size) {
            max = getPrefix(max, strs[i])
        }

        return max
    }

    private fun getPrefix(str1: String, str2: String): String {
        val str = StringBuilder()
        for (i in 0 until Math.min(str1.length, str2.length)) {
            if (str1[i] == str2[i]) str.append(str1[i]) else break
        }
        return str.toString()
    }
}