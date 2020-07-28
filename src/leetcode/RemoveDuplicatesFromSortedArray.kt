package leetcode

class RemoveDuplicatesFromSortedArray {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        var j = 1
        var size = 0
        while (j < nums.size) {
            if (nums[i] == nums[j]) {
                j++
            } else {
                nums[size] = nums[i]

                i = j
                j = i + 1
                size++
            }
        }
        nums[size] = nums[nums.size - 1]

        return ++size
    }
}