package leetcode

fun main() {
    // to test out in console
    val test = FindFirstAndLastPositionOfElementInSortedArray()
    val ans = test.searchRange(intArrayOf(5,7,7,8,8,10), 8)

    ans.forEach { print("$it ") }
    println(ans)
}