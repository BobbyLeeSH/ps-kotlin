package toss

fun main(args: Array<String>) {
    val tossKim = readLine()!!.split(' ').map { it.toInt() }
    val tossLee = readLine()!!.split(' ').map { it.toInt() }
    var debt = 0

    for (i in tossKim.indices) {
        if (debt + tossLee[i] < tossKim[i]) {
            print("${tossKim[i] - debt - tossLee[i]} ")
            debt = 0
        } else {
            print("0 ")
            debt += (tossLee[i] - tossKim[i])
        }
    }
}