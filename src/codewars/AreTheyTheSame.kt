package codewars

class AreTheyTheSame {
    fun comp(a: IntArray?, b: IntArray?): Boolean {
        //your code here
        val sortedA = a?.sorted() ?: return false
        val sortedB = b?.sorted() ?: return false
        if (a.size != b.size) return false

        for (i in sortedA.indices) {
            if (sortedA[i] * sortedA[i] != sortedB[i]) return false
        }

        return true
    }
}