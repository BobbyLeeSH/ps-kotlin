package ps

class SlidingWindow {
    /**
     * Sliding Window strategy
     * When a string or an array is given and wants longest substring without duplication, use Set, starting and ending index.
     * Time Complexity is O(2n0 = O(n)
     */

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
        var max = 0
        var start = 0
        var end = 0
        while (start < s.length && end < s.length) {
            if (charSet.contains(s[end])){
                charSet.remove(s[start])
                start += 1
            } else {
                charSet.add(s[end])
                end += 1
                max = max.coerceAtLeast(end - start)
            }
        }

        return max
    }

}