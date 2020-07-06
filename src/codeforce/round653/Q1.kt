package codeforce.round653

/**
7
7 5 12345
5 0 4
10 5 15
17 8 54321
499999993 9 1000000000
10 5 187
2 0 999999999
 */
fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        val inputs = readLine()!!.split(' ').map { it.toLong() }
        val x = inputs[0]
        val y = inputs[1]
        var k = inputs[2]

        if (y == 0L && x>k) {
            println(0)
            continue
        }

        val mod = k%x // should equal to inputs[1]

        if (mod == y) {
            println(k)
        } else if (mod < y) {
            println (k - mod - x + y)
        } else {
            println (k - mod + y)
        }
    }

}