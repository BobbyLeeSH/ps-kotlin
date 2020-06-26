package hackerrank.array

import java.util.Scanner

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var ret = 0
    for (i in q.indices.reversed()) {
        if (q[i] - (i+1) > 2) {
            println("Too chaotic")
            return
        }
        for (j in Math.max(0, q[i]-2) until i) {
            if (q[j] > q[i]) ret++
        }
    }
    println(ret)
}



fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}