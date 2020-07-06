package codeforce.round653

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        var input = readLine()!!.toInt()
        var count = 0

        while (input % 6 == 0) {
            input /= 6
            count++
        }

        while (input % 3 == 0) {
            input /= 3
            count+=2
        }

        if (input == 1) println(count) else println(-1)
    }

}
/**

7
1
2
3
12
12345
15116544
387420489

 * 
 * 
 * */
