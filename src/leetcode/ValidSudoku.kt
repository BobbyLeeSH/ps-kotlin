package leetcode

class ValidSudoku {
    private val set = mutableSetOf<Char>()
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return validateHorizontal(board) && validateVertical(board) && validateBoxes(board)
    }

    private fun validateVertical(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            set.clear()
            for (j in 0..8) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false
                    else set.add(board[j][i])
                }
            }
        }
        return true
    }

    private fun validateHorizontal(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            val numOfElements = board[i].filter { it != '.' }
            if (numOfElements.size != numOfElements.toSet().size) return false
        }
        return true
    }

    private fun validateBoxes(board: Array<CharArray>): Boolean {
        for (a in 0..2) {
            for (b in 0..2) {
                if (!validateBox(a, b, board)) return false
            }
        }

        return true
    }

    private fun validateBox(a: Int, b: Int, board: Array<CharArray>): Boolean {
        set.clear()
        for (c in 3 * a..3 * a + 2) {
            for (d in 3 * b..3 * b + 2) {
                if (board[c][d] != '.') {
                    if (set.contains(board[c][d])) return false
                    else set.add(board[c][d])
                }
            }
        }
        return true
    }
}