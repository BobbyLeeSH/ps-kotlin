package toss

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    for (v in input) {
        if (map.containsKey(v)) {
            print("${map[v]} ")
        } else {
            val output = compute(v)
            map[v] = output
            print("$output ")
        }
    }
}

// fake function
private fun compute(n: Int): Int {

    return 0
}