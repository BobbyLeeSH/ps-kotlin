package kickstart.y2020.roundD

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val size = readLine()!!.toInt()
        val visitors = readLine()!!.split(" ").map { it.toInt() }
        var count = countRecordBreaker(visitors, size)

        println("Case #$case: $count")
    }
}

private fun countRecordBreaker(visitors: List<Int>, size: Int): Int {
    var count = 0
    var max = 0
    for (i in 0 until size) {
        val one = i == 0 || visitors[i] > max
        val two = i == size - 1 || visitors[i] > visitors[i + 1]
        if (one && two) count++
        max = Math.max(visitors[i], max)
    }
    return count
}