package kakao.intern2020

class Q1 {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = StringBuilder()
        val inputsAsCoords = mutableListOf<Pair<Int, Int>>()
        var left = Pair(3, 0)
        var right = Pair(3, 2)
        for (i in numbers.indices) {
            if (numbers[i] == 0) {
                inputsAsCoords.add(Pair(3, 1))
            } else {
                inputsAsCoords.add(Pair((numbers[i] - 1) / 3, (numbers[i] - 1) % 3))
            }
        }
        inputsAsCoords.forEach {
            if (it.second == 0) {
                left = it
                answer.append("L")
            } else if (it.second == 2) {
                right = it
                answer.append("R")
            } else {
                val rightDst = Math.abs(it.first - right.first) + Math.abs(it.second - right.second)
                val leftDst = Math.abs(it.first - left.first) + Math.abs(it.second - left.second)
                if (rightDst < leftDst) {
                    right = it
                    answer.append("R")
                } else if (leftDst < rightDst) {
                    left = it
                    answer.append("L")
                } else {
                    if (hand == "left") {
                        left = it
                        answer.append("L")
                    } else {
                        right = it
                        answer.append("R")
                    }
                }
            }
        }

        return answer.toString()
    }
}