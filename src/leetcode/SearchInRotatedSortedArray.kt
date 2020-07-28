package leetcode

class SearchInRotatedSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/

    fun search(nums: IntArray, target: Int): Int {
        var ret = -1
        if (nums.isEmpty()) return ret

        var start = 0
        var end = nums.size - 1
        var mid = (start + end) / 2

        while (true) {
            if (nums[mid] == target) return mid
            if (nums[start] == target) return start
            if (nums[end] == target) return end

            if (mid == start || mid == end) break

            if (nums[mid] > nums[start] && target > nums[start] && target < nums[mid]) {
                end = mid
                mid = (start + end) / 2
            } else if (nums[mid] < nums[start] && ((target > nums[start] && target > nums[mid]) || (target < nums[start] && target < nums[mid])) ) {
                end = mid
                mid = (start + end) / 2
            } else {
                start = mid
                mid = (start + end) / 2
            }
        }


        return ret
    }
}