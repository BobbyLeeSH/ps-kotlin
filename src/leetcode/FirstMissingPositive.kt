package leetcode

class FirstMissingPositive {
    // https://leetcode.com/problems/first-missing-positive/

    fun firstMissingPositive(nums: IntArray): Int {
        val found = mutableSetOf<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) found.add(nums[i])
        }

        for (i in 1..Integer.MAX_VALUE) {
            if (!found.contains(i)) return i
        }

        return 0
    }
}