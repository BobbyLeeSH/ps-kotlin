package codeforce.round654

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        val num = readLine()!!.toInt()

        println((num-1)/2 + 1)
    }
}