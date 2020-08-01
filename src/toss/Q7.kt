package toss

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').toMutableList()
    // Staring Pointer
    val sp = input[0].substring(0, input[0].length - 1).toInt()
    input.removeAt(0)

    var type = input[sp].toInt()
    var value = input[sp + 1].toInt()
    var len = 0
    print("0; ")
    while (type == 0 && len + 2 < input.size) {
        len += 2
        print("$type $len ")

        type = input[value].toInt()
        value = input[value + 1].toInt()
    }

    if (len < input.size && type == 1) {
        print("$type $value ")
    }

    while (len + 2 < input.size) {
        print("0 0 ")
        len += 2
    }

}

// 4; 1 30 0 6 0 2 1 3
