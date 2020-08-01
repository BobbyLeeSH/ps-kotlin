package toss

fun main(args: Array<String>) {
    val input = readLine()!!
    if (input[input.length-1] == '1') {
        print("false")
    } else {
        for (i in 0..input.length - 2) {
            if (input[i] == '1' && input[i+1] != '2') {
                print("false")
            }
        }
        print("true")
    }
}