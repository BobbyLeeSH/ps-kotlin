package programmers

class ExpressWithN {
    // https://programmers.co.kr/learn/courses/30/lessons/42895
    
    fun solution(N: Int, number: Int): Int {
        if (number == N) return 1
        val nToValue = mutableMapOf(1 to mutableSetOf(N), 2 to mutableSetOf(), 3 to mutableSetOf(), 4 to mutableSetOf(), 5 to mutableSetOf(), 6 to mutableSetOf(), 7 to mutableSetOf(), 8 to mutableSetOf())
        for (i in 2..8) {
            for (j in 1 until i) {
                nToValue[j]?.forEach { first ->
                    nToValue[i - j]?.forEach { second ->
                        nToValue[i]?.add(first + second)
                        nToValue[i]?.add(first * second)

                        nToValue[i]?.add(first - second)
                        nToValue[i]?.add(second - first)

                        if (second != 0) nToValue[i]?.add(first / second)
                        if (first != 0) nToValue[i]?.add(second / first)
                    }
                }
            }
            val str = StringBuilder()
            for (k in 1..i) {
                str.append(N)
            }
            nToValue[i]?.add(str.toString().toInt())
            if (nToValue[i]?.contains(number) == true) {
                return i
            }
        }

        return -1
    }
}

/**
 * 5
 * 55 5+5 5-5 5*5 5/5 -> 55 10 0 25 1
 * 555 55+5
 */