package atcoder.dp

import kotlin.math.max

// TODO. Not Completed Yet
fun main() {
    val (n, limit) = readLine()!!.split(" ").map { it.toInt() }
    val ws = IntArray(n)
    val vs = IntArray(n)

    for (i in 1..n) {
        val (w, v) = readLine()!!.split(" ").map { it.toInt() }
        ws[i] = w
        vs[i] = v
    }

    val dp = Array(n + 1) { Array(vs.sum()) { Long.MAX_VALUE } }
    for (i in 1..n) {
        for (j in 1..vs.sum()) {
            val curr = ws[i]
            if (j >= curr) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - curr] + vs[i])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    println(dp[n][limit])

}