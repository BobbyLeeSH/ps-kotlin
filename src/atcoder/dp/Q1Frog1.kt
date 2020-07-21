package atcoder.dp

fun main() {
    val size = readLine()!!.toInt()
    val heights = readLine()!!.split(' ').map { it.toInt() }

    val dp = IntArray(size) { 0 }
    dp[1] = Math.abs(heights[0] - heights[1])
    var count = 2
    while (count < size) {
        val c1 = Math.abs(heights[count - 1] - heights[count]) + dp[count - 1]
        val c2 = Math.abs(heights[count - 2] - heights[count]) + dp[count - 2]
        dp[count] = Math.min(c1, c2)
        count++
    }
    println(dp[size - 1])
}