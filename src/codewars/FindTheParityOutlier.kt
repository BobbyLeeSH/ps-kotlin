package codewars

class FindTheParityOutlier {
    fun find(integers: Array<Int>): Int {
        var oddCount = 0
        var evenCount = 0
        for (i in 0..2) {
            if (integers[i] % 2 == 0) evenCount++
            else oddCount++
        }
        return if (evenCount >= 2) integers.first { it % 2 != 0 }
        else integers.first { it % 2 == 0 }
    }
}