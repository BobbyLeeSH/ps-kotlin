package kickstart2020.roundD

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val size = readLine()!!.toInt()
        val pitches = readLine()!!.split(" ").map { it.toInt() }
        var count = 0

        var max = 0
        var min = 0
        for (i in 1 until pitches.size) {
            if (pitches[i - 1] == pitches[i]) continue
            if (pitches[i - 1] > pitches[i]) {
                min++
                max = 0
            } else {
                max++
                min = 0
            }
            if (max > 3 || min > 3) {
                max = 0
                min = 0
                count++
            }
        }

        println("Case #$case: $count")
    }
}