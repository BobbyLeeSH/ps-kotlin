package atcoder.dp

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val h = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(n) { Int.MAX_VALUE }

    dp[0] = 0
    dp[1] = Math.abs(h[0] - h[1])

    var count = 2
    while (count < n) {
        for (i in 1..k) {
            if (count < i) break
            dp[count] = Math.min(dp[count], dp[count - i] + Math.abs(h[count] - h[count - i]))
        }
        count++
    }
    println(dp[n - 1])
}