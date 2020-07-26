package leetcode

class ThreeSumClosest {
    /**
     * https://leetcode.com/problems/3sum-closest/
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example 1:

    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


    Constraints:

    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
     */

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closest = nums[0] + nums[1] + nums[2]
        nums.sort()
        for (i in 0 until nums.size - 2) {
            var j = i + 1
            var k = nums.size - 1

            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                val diff = sum - target
                if (Math.abs(closest - target) > Math.abs(diff)) closest = sum
                if (diff == 0) {
                    break
                } else if (diff < 0) {
                    j++
                } else {
                    k--
                }

            }
        }

        return closest
    }
}