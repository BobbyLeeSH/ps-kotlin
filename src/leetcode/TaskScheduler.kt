package leetcode

class TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (tasks.isEmpty() || n == 0) return tasks.size
        val occurrence = tasks.toList().groupingBy { it }.eachCount().values.sortedDescending()
        val maxCount = occurrence[0]
        var idle = (maxCount - 1) * n
        println(idle)
        for (i in 1 until occurrence.size) {
            idle -= Math.min(occurrence[i], maxCount - 1)
        }
        println(idle)
        if (idle < 0) return tasks.size
        return idle + tasks.size
    }
}