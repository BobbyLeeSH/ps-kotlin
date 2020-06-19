package ps

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        var array2D = Array(numRows) { StringBuilder() }
        var currIndex = 0
        var goingDown = true
        s.forEach {
            array2D[currIndex].append(it)
            when (goingDown) {
                true -> {
                    if (currIndex == numRows - 1) {
                        goingDown = false
                        currIndex--
                    } else {
                        currIndex++
                    }
                }
                else -> {
                    if (currIndex == 0) {
                        goingDown = true
                        currIndex++
                    } else {
                        currIndex--
                    }
                }
            }
        }
        var ret = StringBuilder()
        array2D.forEach { ret.append(it) }
        return ret.toString()
    }
}

/**
case 1. row = 3
0 + 4 + 4 + ...
1 + 2 + 2 + ...
2 + 4 + 4 + ...

case 2. row = 4

 */