package kickstart.y2020.roundE

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (n, a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        val miss = n + c - a - b
        if (a + b - c > n || (a == 1 && b == 1 && c == 1 && n > 1)) {
            print("Case #$case: IMPOSSIBLE")
        } else {
            var curr = 0
            val heights = IntArray(n) { 0 }
            for (i in curr until a - c) {
                heights[i] = n - 1
                curr++
            }

            if (c > 1) {
                heights[curr] = n
                curr++
                for (i in curr until curr + miss) {
                    heights[i] = 1
                    curr++
                }
                for (i in curr until curr + c - 1) {
                    heights[i] = n
                    curr++
                }
            } else {
                if (a>1) {
                    for (i in curr until curr + miss) {
                        heights[i] = 1
                        curr++
                    }
                    for (i in curr until curr + c) {
                        heights[i] = n
                        curr++
                    }
                } else {
                    for (i in curr until curr + c) {
                        heights[i] = n
                        curr++
                    }
                    for (i in curr until curr + miss) {
                        heights[i] = 1
                        curr++
                    }
                }
            }
            for (i in curr until n) {
                heights[i] = n - 1
                curr++
            }

            print("Case #$case: ")
            heights.forEach { print("$it ") }
        }
        println()
    }
}
