package codeforce.round653

fun main() {
    val cases = readLine()!!.toInt()

    for (case in 0 until cases) {
        var size = readLine()!!.toInt()
        var str = readLine()!!
        var flag = 0
        var min = 0
        for (i in 0 until size) {
            if (str[i] == '(') {
                flag++
            } else {
                flag--
                min = min.coerceAtMost(flag)
            }
        }
        println(-min)
    }
}