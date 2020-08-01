package toss

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').map { it.toInt() }

    if (input.size != input.toSet().size || input.size != 6) {
        print("false")
    } else if (input.any { it > 45 }) {
        print("false")
    } else {
        for (i in  0..4) {
            if (input[i] >= input[i+1]) {
                print("false")
                return
            }
        }
        print("true")
    }

}