package hackerrank.array

import java.util.Scanner

// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var max = 0L
    val arr = LongArray(n)
    queries.forEach {
        arr[it[0] - 1] = arr[it[0] - 1] + it[2]
        if (it[1] < n) arr[it[1]] = arr[it[1]] - it[2]
    }

    var curr = 0L
    arr.forEach {
        curr += it
        max = curr.coerceAtLeast(max)
    }
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}