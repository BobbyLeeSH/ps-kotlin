package codeforce.round653

fun main() {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        var inputs = readLine()!!.split(' ').map { it.toInt() }
        val n = inputs[0]
        val k = inputs[1]
        val checkArray = IntArray(n)

        var numList = readLine()!!.split(' ').map { it.toInt() }.toMutableList()

        numList.indices.forEach {
            if (numList[it] % k == 0) checkArray[it] = 1
        }
        var x = 0
        while (checkArray.sum() != n) {
            val nextIndex = numList.indices.filter { checkArray[it] == 0 }.maxBy { Math.floorMod(numList[it], k) }!!
            x += Math.floorMod((k - numList[nextIndex] - x), k)
            println(x)
            numList[nextIndex] += x
            checkArray[nextIndex] = 1
            x++
            println(numList.toString())
        }
        println(x)
    }
}