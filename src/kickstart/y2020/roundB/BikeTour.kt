package kickstart.y2020.roundB

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var count = 0
        var size = readLine()!!.toInt()
        var checkPoints = readLine()!!.split(' ').map { it.toInt() }

        for (i in 1..size - 2) {
            if (checkPoints[i - 1] < checkPoints[i] && checkPoints[i + 1] < checkPoints[i]) {
                count++
            }
        }

        println("Case #$case: $count")
    }
}