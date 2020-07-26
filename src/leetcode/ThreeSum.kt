package leetcode

class ThreeSum {
    /**
     * https://leetcode.com/problems/3sum/

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]

     */

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ans = mutableListOf<List<Int>>()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i-1]) continue

            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        ans.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                        k--
                        while (nums[j] == nums[j - 1] && j < k) j++
                        while (nums[k] == nums[k + 1] && j < k) k--
                    }
                    sum > 0 -> {
                        k--
                    }
                    else -> {
                        j++
                    }
                }
            }
        }

        return ans
    }
}