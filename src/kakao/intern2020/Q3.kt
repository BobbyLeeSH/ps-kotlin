package kakao.intern2020

class Q3 {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)
        var min = gems.size + 1
        val distinctSize = gems.distinct().size
        var end = distinctSize - 1
        var start = 0

        while (end < gems.size) {
            val temp = gems.slice(start..end)
//            println(temp)
            if (temp.distinct().size == distinctSize && min > end-start) {
                min = Math.min(min, end - start)
                answer[0] = start+1
                answer[1] = end+1
                start++
            } else {
                end++
            }
//            println(min)
        }

        return answer
    }
}

fun main() {
    val input = listOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    val sol = Q3()
    println(sol.solution(input.toTypedArray()).toList().toString())
}