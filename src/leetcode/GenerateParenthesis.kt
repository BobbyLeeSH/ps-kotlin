package leetcode

class GenerateParenthesis {

    // https://leetcode.com/problems/generate-parentheses/

    fun generateParenthesis(n: Int): List<String> {
        val ret = mutableListOf<String>()
        if (n == 0) return ret

        rec(ret, StringBuilder(), "(", n, 1, 0)

        return ret
    }

    private fun rec(ret: MutableList<String>, curr: StringBuilder, add: String, n: Int, open: Int, close: Int) {
        var temp = StringBuilder(curr)
        temp.append(add)

        if (open == n && close == n) {
            ret.add(temp.toString())
            return
        }
        if (close == n) return
        if (close > open) return

        if (open == n) {
            rec(ret, temp, ")", n, open, close + 1)
        } else {
            rec(ret, temp, "(", n, open + 1, close)
            rec(ret, temp, ")", n, open, close + 1)
        }
    }
}