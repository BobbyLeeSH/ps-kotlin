package kickstart.y2020.roundE

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val size = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var max = 0
        var curr = 2
        var diff = arr[1] - arr[0]
        for (i in 1 until size - 1) {
            if (arr[i + 1] - arr[i] == diff) {
                curr++
            } else {
                max = Math.max(max, curr)
                diff = arr[i + 1] - arr[i]
                curr = 2
            }
        }
        max = Math.max(max, curr)

        println("Case #$case: $max")
    }
}