package kakao.intern2020

class Q2 {

    fun solution(expression: String): Long {
        var answer: Long = 0
        val cases = listOf("*+-", "*-+", "+*-", "+-*", "-*+", "-+*")
        val numsOrder = expression.split('*', '-', '+').map { it.toLong() }
        val opsOrder = expression.filter { it in "*+-" }
        cases.forEach { ops ->
            val tempNums = numsOrder.toMutableList()
            val tempOps = opsOrder.toMutableList()
            ops.forEach { op ->
                var index = tempOps.indexOfFirst { it == op }
                while (index >= 0) {
                    val result = when (op) {
                        '*' -> tempNums[index] * tempNums[index + 1]
                        '+' -> tempNums[index] + tempNums[index + 1]
                        '-' -> tempNums[index] - tempNums[index + 1]
                        else -> 0
                    }
                    tempNums[index + 1] = result
                    tempNums.removeAt(index)
                    tempOps.removeAt(index)
                    index = tempOps.indexOfFirst { it == op }
                    println("$tempNums")
                    println("$tempOps")
                }
            }
            answer = answer.coerceAtLeast(Math.abs(tempNums[0]))

        }

        return answer
    }
}

fun main() {
    val input = "100-200*300-500+20"
    val sol = Q2()
    println(sol.solution(input))
}