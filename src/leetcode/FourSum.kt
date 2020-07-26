package leetcode

class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 3) {
            for (j in i + 1 until nums.size - 2) {
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if (sum == target) {
                        if (!ret.contains(listOf(nums[i], nums[j], nums[left], nums[right]))) ret.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--
                        while (left < right && nums[left] == nums[left - 1]) left++
                        while (left < right && nums[right] == nums[right + 1]) right--
                    } else if (sum < target) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }


        return ret
    }
}