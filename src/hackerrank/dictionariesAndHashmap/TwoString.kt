package hackerrank.dictionariesAndHashmap

import java.util.Scanner

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    val wordToCounts1 = s1.groupingBy { it }.eachCount()


    s2.forEach {
        if (wordToCounts1.containsKey(it)) {
            return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}