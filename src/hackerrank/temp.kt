package hackerrank

class temp {

    fun repeatedString(s: String, n: Long): Long {
        val numOfA = s.filter { it == 'a' }.length
        val repeat = n/s.length
        val mainLen = repeat * s.length
        val total = repeat*numOfA + s.substring(0, (n - mainLen).toInt()).filter { it == 'a' }.length
        return total
    }
}