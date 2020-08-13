package kickstart.y2017.roundC

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (total, pick) = readLine()!!.split(' ').map { it.toInt() }
        val cylinders = mutableListOf<Cylinder>()
        repeat(total) {
            val (radius, height) = readLine()!!.split(' ').map { it.toDouble() }
            cylinders.add(Cylinder(radius, height))
        }
        cylinders.sortByDescending { it.radius }

        var max = 0.0
        while (cylinders.size >= pick) {
            val base = cylinders[0].getCylinderArea()
            cylinders.removeAt(0)
            val sum = base + cylinders.sortedByDescending { it.getSideArea() }.subList(0, pick - 1).sumByDouble { it.getSideArea() }
            max = Math.max(max, sum)
        }

        println("Case #$case: $max")
    }
}

data class Cylinder(
    val radius: Double,
    val height: Double
) {
    fun getCylinderArea(): Double {
        return radius * radius * Math.PI + getSideArea()
    }

    fun getSideArea(): Double {
        return 2 * radius * height * Math.PI
    }
}