package kickstart.y2019.roundA

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (size, pick) = readLine()!!.split(' ').map { it.toInt() }
        val candidates = readLine()!!.split(' ').map { it.toLong() }.sorted()

        var min = 0L
        for (i in 0 until pick - 1) {
            min += (candidates[pick - 1] - candidates[i])
        }
        var curr = min
        for (i in 0 until size - pick) {
            curr =
                curr - (candidates[i + pick - 1] - candidates[i]) + (candidates[i + pick] - candidates[i + pick - 1]) * (pick - 1)
            min = Math.min(curr, min)
        }

        println("Case #$case: $min")
    }
}