package codeforce.`20200625`

class Game01 {
    fun sol() {
        val num = readLine()!!.toInt()
        for (i in 1..num) {
            var str = readLine()!!
            var count = 0
            while (str.contains("01") || str.contains("10")) {
                val index01 = str.indexOf("01")
                if (index01 >= 0) {
                    str = str.removeRange(index01, index01+2)
                } else {
                    val index02 = str.indexOf("10")
                    str = str.removeRange(index02, index02+2)
                }
                count++
            }
            if (count%2 == 1) println("DA") else println("NET")
        }
    }
}