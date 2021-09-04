package codewars

import java.lang.StringBuilder

// https://www.codewars.com/kata/55c6126177c9441a570000cc/solutions/kotlin
class WeightForWeight {
    fun orderWeight(string: String): String {
        val weights = string.split(" ")
        val weightsPairList = mutableListOf<Pair<String, Int>>()

        for (weight in weights) {
            val weightDigits = weight.chunked(1)
            val sum = weightDigits.sumBy { it.toInt() }
            weightsPairList.add(Pair(weight, sum))
        }

        val sorted = weightsPairList.sortedWith(compareBy({ it.second }, { it.first }))

        val ret = StringBuilder()
        for (pair in sorted) {
            ret.append(pair.first).append(" ")
        }

        return ret.toString().trim()
    }
}