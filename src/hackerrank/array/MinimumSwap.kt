package hackerrank.array

import java.util.Scanner

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var count = 0
    for (i in arr.indices) {
        while (arr[i]-1 != i) {
            swap(arr, i)
            count++
        }
    }
    return count
}

private fun swap(arr: Array<Int>, i: Int) {
    val temp = arr[arr[i]-1]
    arr[arr[i]-1] = arr[i]
    arr[i] = temp
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}