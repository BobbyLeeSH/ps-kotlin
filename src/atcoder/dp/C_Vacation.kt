package atcoder.dp

private const val ACTIVITY_COUNT = 3
fun main() {
    val days = readLine()!!.toInt()
    val h = mutableListOf<List<Int>>()
    val dp = Array(days) { IntArray(ACTIVITY_COUNT) { 0 } }
    for (i in 0 until days) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        h.add(input)
    }
    dp[0][0] = h[0][0]
    dp[0][1] = h[0][1]
    dp[0][2] = h[0][2]

    for (i in 1 until days) {
        for (j in 0 until ACTIVITY_COUNT) {
            val a = Math.floorMod(j + 1, 3)
            val b = Math.floorMod(j + 2, 3)
            dp[i][j] = h[i][j] + Math.max(dp[i-1][a], dp[i-1][b])
        }
    }

    val ans = Math.max(dp[days-1][0], Math.max(dp[days-1][1], dp[days-1][2]))
    println(ans)
}

private fun printDp(dp: Array<IntArray>) {
    dp.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
    println("--------------------------------")
}