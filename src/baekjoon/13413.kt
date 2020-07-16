package baekjoon

fun main() {
    val cases = readLine()!!.toInt()
    for (i in 0 until cases) {
        val size = readLine()!!.toInt()
        val asIs = readLine()!!
        val toBe = readLine()!!
        var BtoW = 0
        var WtoB = 0
        for (j in 0 until size) {
            if (asIs[j] == 'B' && toBe[j] == 'W') BtoW++
            if (asIs[j] == 'W' && toBe[j] == 'B') WtoB++
        }
        println(Math.max(BtoW, WtoB))
    }
}