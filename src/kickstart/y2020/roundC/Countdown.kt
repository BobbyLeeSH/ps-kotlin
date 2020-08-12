package kickstart.y2020.roundC

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val target = readLine()!!.split(' ').map { it.toInt() }[1]
        var numList = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
        val mCountdown = (target downTo 1).toList()

        var count = 0
        var index = numList.indexOfFirst { it == target }
        while (index >= 0) {
            if (index + target - 1 >= numList.size) break
            var found = true
            for (i in mCountdown.indices) {
                if (mCountdown[i] != numList[i + index]) {
                    found = false
                    break
                }
            }
            numList = if (found) {
                count++
                numList.subList(index + target, numList.size)
            } else {
                numList.subList(index + 1, numList.size)
            }
            index = numList.indexOfFirst { it == target }
        }
        println("Case #$case: $count")
    }
}

