package baekjoon

import kotlin.math.sqrt

fun main() {
    var input = readLine()!!.toInt()
    for (i in 2..sqrt(input.toDouble()).toInt()) {
        while (input % i == 0) {
            println(i)
            input /= i
        }
    }

    if (input != 1) println(input);
}