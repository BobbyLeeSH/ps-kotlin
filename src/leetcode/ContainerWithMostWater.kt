package leetcode

class ContainerWithMostWater {
    // https://leetcode.com/problems/container-with-most-water/

    fun maxAreaBrute(height: IntArray): Int {
        var max = 0
        for (start in height.indices) {
            for (next in start + 1 until height.size) {
                val maxHeight = height[start].coerceAtMost(height[next])
                max = (maxHeight * (next - start)).coerceAtLeast(max)
            }
        }
        return max
    }

    fun maxAreaOptimized(height: IntArray): Int {
        var max = 0
        var start = 0
        var end = height.size - 1

        while (start < end) {
            val left = height[start]
            val right = height[end]
            val area = Math.min(left, right) * (end - start)
            max = Math.max(area, max)
            if (left < right) start++ else end--
        }
        return max
    }
}