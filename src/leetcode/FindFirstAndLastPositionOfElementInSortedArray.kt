package leetcode

class FindFirstAndLastPositionOfElementInSortedArray {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val notFound = intArrayOf(-1, -1)
        if (nums.isEmpty()) return notFound

        var i = 0
        var j = nums.size - 1
        var mid = (i + j) / 2

        while (true) {
            if (nums[mid] == target) return findRange(mid, nums, target)
            if (nums[i] == target) return findRange(i, nums, target)
            if (nums[j] == target) return findRange(j, nums, target)

            if (i == mid || j == mid) break

            if (nums[mid] > target) {
                j = mid
                mid = (i + j) / 2
            } else {
                i = mid
                mid = (i + j) / 2
            }
        }


        return notFound
    }

    private fun findRange(mid: Int, nums: IntArray, target: Int): IntArray {
        var first = mid - 1
        while (first >= 0) {
            if (nums[first] != target) break
            --first
        }

        var last = mid + 1
        while (last < nums.size) {
            if (nums[last] != target) break
            ++last
        }

        return intArrayOf(first + 1, last - 1)
    }
}