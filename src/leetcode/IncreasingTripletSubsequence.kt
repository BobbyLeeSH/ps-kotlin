package leetcode

class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        var a = Int.MAX_VALUE
        var b = Int.MAX_VALUE
        var c = Int.MAX_VALUE

        for (num in nums) {
            if (num < a) {
                a = num
            } else if (a< num && num < b) {
                b = num
            } else if (num > a && num > b && num < c) {
                return true
            }
        }

        return false
    }
}