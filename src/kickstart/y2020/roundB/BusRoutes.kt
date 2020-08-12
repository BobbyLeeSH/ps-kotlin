package kickstart.y2020.roundB

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (size, targetD) = readLine()!!.split(' ').map { it.toLong() }
        val buses = readLine()!!.split(' ').map { it.toLong() }
        var curr = targetD

        for (i in size - 1 downTo 0) {
            if ((curr % buses[i.toInt()]).toInt() == 0) continue
            val temp = curr / buses[i.toInt()]
            curr = temp * buses[i.toInt()]
        }

        println("Case #$case: $curr")
    }
}