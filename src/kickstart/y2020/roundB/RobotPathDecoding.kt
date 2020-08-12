package kickstart.y2020.roundB

fun main() {
    val cases = readLine()!!.toInt()
    val totalSize = 1000000000
    for (case in 1..cases) {
        val commands = readLine()!!
        val directions = getDirections(commands)

        val x = Math.floorMod(directions.x.toInt(), totalSize)
        val y = Math.floorMod(directions.y.toInt(), totalSize)

        println("Case #$case: ${x + 1} ${y + 1}")
    }
}

private fun getDirections(commands: String): Directions {
    var directions = commands.split('(', ')').map { Directions(it) }.toMutableList()
    var brackets = commands.filter { it in listOf('(', ')') }

//    println(directions.toString())
    return if (brackets.isEmpty()) {
        Directions(commands)
    } else {
        var index = brackets.indexOf("()")
        while (index >= 0) {
            val first = directions[index]
            val second = directions[index + 1]
            val last = directions[index + 2]
//            println("first: $first")
//            println("second: $second")
//            println("last: $last")

            val retDir = second.multiply(first.nextDigit).add(first).add(last).setNextDigit(last.nextDigit)

//            println(retDir)
//            println("------------------")

            directions.removeAt(index)
            directions.removeAt(index)
            directions[index] = retDir

            brackets = brackets.replaceFirst("()", "")

            index = brackets.indexOf("()")
        }
        directions[0]
    }
}

data class Directions(
    var x: Long = 0,
    var y: Long = 0,
    var nextDigit: Int = 0
) {
    constructor(str: String) : this() {
        val xPlus = str.count { it == 'E' }
        val xMinus = str.count { it == 'W' }
        val yPlus = str.count { it == 'S' }
        val yMinus = str.count { it == 'N' }
        x = (xPlus - xMinus).toLong()
        y = (yPlus - yMinus).toLong()
        if (str.isNotEmpty() && str.last() in '2'..'9') {
            nextDigit = str.last().toString().toInt()
        }
    }

    fun multiply(n: Int): Directions {
        x *= n
        y *= n

        return this
    }

    fun add(dir: Directions): Directions {
        x += dir.x
        y += dir.y

        x = Math.floorMod(x, 1000000000)
        y = Math.floorMod(y, 1000000000)

        return this
    }

    fun setNextDigit(digit: Int): Directions {
        nextDigit = digit
        return this
    }
}

/**
 *
6
SSSEEE
N
N3(S)N2(E)N
2(3(NW)2(W2(EE)W))
2(5(2(E)WE)3(N))
9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(E)))))))))))))))))))))))))))))))))))))))))))))))

 */
