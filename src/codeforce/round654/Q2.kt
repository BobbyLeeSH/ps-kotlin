package codeforce.round654

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()
    for (case in 0 until cases) {
        val nums = readLine()!!.split(' ').map { it.toLong() }
        if (nums[0] > nums[1]) {
            println((nums[1] + 1) * nums[1] / 2)
        } else {
            println(((nums[0] * (nums[0] - 1)) / 2) + 1)
        }
    }
}