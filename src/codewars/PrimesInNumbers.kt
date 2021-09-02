package codewars

class PrimesInNumbers {
    fun factors(l: Int): String {
        // your code
        val str = StringBuilder()
        val primes = getAllPrimes(l)
        var temp = l
        for (prime in primes) {
            var count = 0
            while (temp % prime == 0) {
                count++
                temp /= prime
            }
            if (count == 1) {
                str.append("($prime)")
            } else if (count >= 1) {
                str.append("($prime**$count)")
            }
        }
        if (temp != 1) str.append("($temp)")
        return str.toString()
    }

    private fun getAllPrimes(l: Int): List<Int> {
        val ret = mutableListOf(2)
        for (i in 3..Math.sqrt(l.toDouble()).toInt()) {
            if (isPrime(i)) ret.add(i)
        }
        return ret
    }

    private fun isPrime(number: Int): Boolean {
        for (i in 2 until number) {
            if (number % i == 0) return false
        }
        return true
    }
}