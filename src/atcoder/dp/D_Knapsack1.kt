package atcoder.dp

import kotlin.math.max

fun main() {
    val (n, limit) = readLine()!!.split(" ").map { it.toInt() }
    val ws = mutableListOf<Int>(0)
    val vs = mutableListOf<Long>(0L)

    repeat(n) {
        val (w, v) = readLine()!!.split(" ").map { it.toInt() }
        ws.add(w)
        vs.add(v.toLong())
    }

    val dp = Array(n + 1) { Array(limit + 1) { 0L } }
    for (i in 1..n) {
        for (j in 1..limit) {
            val curr = ws[i]
            if (j >= curr) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - curr] + vs[i])
            } else {
                dp[i][j] = dp[i-1][j]
            }
        }
    }

    println(dp[n][limit])

}