package kickstart.y2020.roundA

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var count = 0
        var spent = 0
        val (total, budget) = readLine()!!.split(' ').map { it.toInt() }
        val houses = readLine()!!.split(' ').map { it.toInt() }.sorted()

        for (i in 0 until total) {
            if (spent + houses[i] > budget) break

            spent += houses[i]
            count++
        }

        println("Case #$case: $count")
    }
}