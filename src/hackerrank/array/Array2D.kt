package hackerrank.array

import java.util.Scanner

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    // 0,0 0,1 0,2 1,1 2,0 2,1 2,2
    var max = getSum(arr, 0, 0)

    for (i in 0..3) {
        for (j in 0..3) {
            max = max.coerceAtLeast(getSum(arr, i, j))
        }
    }

    return max
}

private fun getSum(arr: Array<Array<Int>>, i: Int, j: Int): Int {
    return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
