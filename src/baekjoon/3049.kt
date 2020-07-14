package baekjoon

fun main() {
    val cases = readLine()!!.toInt()
    println(cases*(cases-1)*(cases-2)*(cases-3)/24)
}