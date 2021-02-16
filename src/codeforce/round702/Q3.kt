package codeforce.round702

fun main(args: Array<String>) {
    val cases = readLine()!!.toInt()
    for (case in 0 until cases) {
        yesOrNo()
    }
}

fun yesOrNo() {
    val number = readLine()!!.toLong()
    val pow3Set = mutableSetOf(1L)
    val pow3List = mutableListOf(1L)
    var pow3 = 8L
    var base = 2L
    while (pow3 <= number) {
        pow3 = Math.multiplyExact(base, Math.multiplyExact(base, base))
        pow3Set.add(pow3)
        pow3List.add(pow3)
        base += 1
    }

    for (num in pow3List) {
        if (pow3Set.contains(number - num)) {
            println("YES")
            return
        }
    }
    println("NO")
}