package codeforce.round702

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()
    for (i in 0 until cases) {
        val size = readLine()!!.toInt()
        val numbers = readLine()!!.split(" ").map { it.toInt() % 3 }

        val occurrenceMap = numbers.groupingBy { it }.eachCount().toMutableMap()
        occurrenceMap[0] = occurrenceMap[0] ?: 0
        occurrenceMap[1] = occurrenceMap[1] ?: 0
        occurrenceMap[2] = occurrenceMap[2] ?: 0
        if (occurrenceMap[0]!! == occurrenceMap[1]!! && occurrenceMap[1]!! == occurrenceMap[2]!!) {
            println(0)
            continue
        }

        var count = 0

        if (occurrenceMap[0]!! > size / 3) {
            if (occurrenceMap[1]!! < size / 3) {
                count += (Math.min(occurrenceMap[0]!! - size / 3, size / 3 - occurrenceMap[1]!!))
            }
            if (occurrenceMap[2]!! < size / 3) {
                count += 2 * (Math.min(occurrenceMap[0]!! - size / 3, size / 3 - occurrenceMap[2]!!))
            }
        }
        if (occurrenceMap[1]!! > size / 3) {
            if (occurrenceMap[2]!! < size / 3) {
                count += (Math.min(occurrenceMap[1]!! - size / 3, size / 3 - occurrenceMap[2]!!))
            }
            if (occurrenceMap[0]!! < size / 3) {
                count += 2 * (Math.min(occurrenceMap[1]!! - size / 3, size / 3 - occurrenceMap[0]!!))
            }
        }
        if (occurrenceMap[2]!! > size / 3) {
            if (occurrenceMap[0]!! < size / 3) {
                count += (Math.min(occurrenceMap[2]!! - size / 3, size / 3 - occurrenceMap[0]!!))
            }
            if (occurrenceMap[1]!! < size / 3) {
                count += 2 * (Math.min(occurrenceMap[2]!! - size / 3, size / 3 - occurrenceMap[1]!!))
            }
        }
        println(count)
    }
}