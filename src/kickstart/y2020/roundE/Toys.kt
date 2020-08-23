package kickstart.y2020.roundE

// INCOMPLETE :(
fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var remove = 0

        val size = readLine()!!.toInt()
        val toys = mutableListOf<List<Int>>()
        repeat(size) {
            val toy = readLine()!!.split(" ").map { it.toInt() }
            toys.add(toy)
        }

        var (removed, sum) = getTime(toys)
        var max = sum
        while (true) {
            if (sum == -1) {
                remove = toys.size - removed.size
                println("Case #$case: $remove INDEFINITELY")
                break
            } else if (removed.size == 0) {
                println("Case #$case: $remove $max")
                break
            } else {
                if (max < sum) {
                    remove = toys.size - removed.size
                    max = sum
                }
                val ret = getTime(removed)
                removed = ret.first
                sum = ret.second
            }
        }
    }
}

private fun getTime(toys: MutableList<List<Int>>): Pair<MutableList<List<Int>>, Int> {
    var sum = toys.sumBy { it[0] }
    for (toy in toys) {
        val temp = toys.map { it }.toMutableList()
        temp.remove(toy)
        if (temp.sumBy { it[0] } < toy[1]) {
            return Pair(temp, sum)
        }
        sum+=toy[0]
    }
    return Pair(toys, -1)
}