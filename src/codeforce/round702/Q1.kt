package codeforce.round702

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()
    for (case in 0 until cases) {
        val size = readLine()!!.toInt()
        val array = readLine()!!.split(" ").map { it.toInt() }
        var count = 0

        for (i in 0 until size - 1) {
            var denseValue = Math.max(array[i].toDouble(), array[i + 1].toDouble()) / Math.min(
                array[i].toDouble(),
                array[i + 1].toDouble()
            )
            if (denseValue > 2) {
                while (denseValue > 2) {
                    denseValue /= 2
                    count += 1
                }
            }
        }
        println(count)
    }
}