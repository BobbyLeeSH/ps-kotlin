package ps

class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        if (s.isEmpty() || p.isEmpty() || p[0] == '*') return false

        return true
    }
}