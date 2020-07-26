package leetcode

class MedianOfTwoArray {
    // https://leetcode.com/problems/median-of-two-sorted-arrays/

    /**
    There are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    You may assume nums1 and nums2 cannot be both empty.

    Example 1:

    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0
    Example 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5
     */

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var index = 0
        while (i <nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                mergedArray[index++] = nums1[i++]
            } else {
                mergedArray[index++] = nums2[j++]
            }
        }

        if (i == nums1.size) {
            while (j < nums2.size) {
                mergedArray[index++] = nums2[j++]
            }
        } else {
            while (i < nums1.size) {
                mergedArray[index++] = nums1[i++]
            }
        }

        val middle:Int = mergedArray.size/2

        return if (mergedArray.size % 2 == 1) {
            mergedArray[middle].toDouble()
        } else {
            ((mergedArray[middle] + mergedArray[middle-1])).toDouble()/2
        }
    }
}