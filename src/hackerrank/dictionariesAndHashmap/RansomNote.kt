package hackerrank.dictionariesAndHashmap

import java.util.Scanner

fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val wordToCountMag = magazine.groupingBy { it }.eachCount()
    val wordToCountNote = note.groupingBy { it }.eachCount()

    wordToCountNote.forEach {
        if (!wordToCountMag.containsKey(it.key) || wordToCountMag[it.key]!! < it.value) {
            println("No")
            return
        }
    }
    println("Yes")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}