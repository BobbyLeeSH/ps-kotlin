package baekjoon

fun main() {
    val cases = readLine()!!.toInt()
    repeat(cases) {
        val (start, end) = readLine()!!.split(" ").map { it.toInt() }
        val dist = end - start
        if (dist <= 3) {
            println(dist)
            return@repeat
        }
        var count = 0
        var jump = 1
        var i = 0
        var j = dist

        while (i < j) {
            i += jump
            count++

            if (i >= j) break

            j -= jump
            count++

            jump++
        }
        println(count)
    }
}