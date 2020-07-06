package codeforce.round654

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        val nums = readLine()!!.split(' ').map { it.toLong() }
        if (nums[0] + nums[1] < nums[2] + nums[3]) {
            println("No")
        }
        else {
            println("Yes")
        }
    }

}