package toss

import java.util.LinkedList

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val recent = LinkedList<String>()

    for (pay in input) {
        if (recent.size == 5) {
            if (recent.contains(pay)) {
                recent.remove(pay)
            } else {
                recent.removeLast()
            }
            recent.addFirst(pay)
        } else {
            if (recent.contains(pay)) {
                recent.remove(pay)
                recent.addFirst(pay)
            } else {
                recent.addFirst(pay)
            }
        }

        recent.forEach{
            print("$it ")
        }
        println()
    }
}