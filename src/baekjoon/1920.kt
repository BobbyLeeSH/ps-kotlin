package baekjoon

fun main() {
    val m = readLine()!!.toInt()
    val integers = readLine()!!.split(" ").map { it.toInt() }

    val n = readLine()!!.toInt()
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val sorted = integers.sorted()

    for (target in targets) {
        println(binarySearch(sorted, 0, m - 1, target))
    }
}

fun binarySearch(sorted: List<Int>, start: Int, end: Int, target: Int): Int {
    if (start > end) return 0
    val pivot = (start + end) / 2

    return if (sorted[pivot] == target) 1
    else if (sorted[pivot] > target) binarySearch(sorted, start, pivot - 1, target)
    else binarySearch(sorted, pivot + 1, end, target)
}