package toss

fun main(args: Array<String>) {
    val board = readLine()!!.split(';').map { it.split(' ') }
    var circumference = 0
    for (i in 1 until board.size - 1) {
        for (j in 1 until board[i].size - 1) {
            if (board[i][j] == "1") {
                if (board[i-1][j] == "0") circumference++
                if (board[i+1][j] == "0") circumference++
                if (board[i][j-1] == "0") circumference++
                if (board[i][j+1] == "0") circumference++
            }
        }
    }
    println(circumference)
}

// testcase
// 0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0
// 0 0 0 0;0 1 1 0;0 1 1 0;0 0 0 0
// 0 0 0 0 0;0 1 1 0 0;0 0 1 0 0;0 1 1 1 0;0 0 0 0 0
// 0 0 0 0 0;0 1 1 1 0;0 1 0 1 0;0 1 1 1 0;0 0 0 0 0