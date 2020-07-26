package leetcode

private val NUM_TO_CHARS = mapOf('2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl", '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz")

class LetterCombination {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    fun letterCombinations(digits: String): List<String> {
        val ret = mutableListOf<String>()
        if (digits.isEmpty()) return ret

        rec(ret, "", 0, digits)

        return ret
    }

    private fun rec(ret: MutableList<String>, curr: String, next: Int, digits: String) {
        if (curr.length == digits.length) {
            ret.add(curr)
            return
        }

        NUM_TO_CHARS[digits[next]]!!.forEach {
            rec(ret, curr + it, next + 1, digits)
        }
    }
}