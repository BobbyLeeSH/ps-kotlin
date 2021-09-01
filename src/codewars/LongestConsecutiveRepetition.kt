package codewars

class LongestConsecutiveRepetition {
    fun longestRepetition(s: String): Pair<Char?, Int> {
        if (s.isEmpty()) return Pair(null, 0)

        var maxChar: Char? = null
        var maxLength = 0
        var tempChar = s[0]
        var tempLength = 1

        for (i in 1 until s.length) {
            if (tempChar == s[i]) {
                tempLength++
            } else {
                if (tempLength > maxLength) {
                    maxChar = tempChar
                    maxLength = tempLength
                }
                tempChar = s[i]
                tempLength = 1
            }
        }
        if (tempLength > maxLength) {
            maxChar = tempChar
            maxLength = tempLength
        }

        return Pair(maxChar, maxLength)
    }
}