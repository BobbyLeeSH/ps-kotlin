package kakao.employ2020

class StringZip {
    fun solution(s: String): Int {
        var min = s.length
        for (i in 1..s.length / 2) {
            val chunked = s.chunked(i).toMutableList()
            val countList = mutableListOf<Int>()
            val sList = mutableListOf<String>()
            var count = 1
            val str = StringBuilder()
            for (j in 0 until chunked.size - 1) {
                if (chunked[j] == chunked[j + 1]) {
                    count++
                } else {
                    sList.add(chunked[j])
                    countList.add(count)
                    count = 1
                }
            }
            sList.add(chunked[chunked.size - 1])
            countList.add(count)

            countList.indices.forEach {
                if (countList[it] > 1) {
                    str.append(countList[it])
                }
                str.append(sList[it])
            }
            min = Math.min(min, str.length)
        }

        return min
    }
}

fun main() {
    val sol = StringZip()
    val input = "xababcdcdababcdcd"

    println(sol.solution(input))
}