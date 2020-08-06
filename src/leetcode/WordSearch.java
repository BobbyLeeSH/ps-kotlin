package leetcode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty() || board.length == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && bfs(i, j, 0, board, word)) return true;
            }
        }

        return false;
    }

    private boolean bfs(int i, int j, int count, char[][] board, String word) {
        if (word.length() == count) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count))
            return false;

        char temp = board[i][j];
        count++;
        board[i][j] = ' ';
        boolean ret = bfs(i - 1, j, count, board, word) || bfs(i + 1, j, count, board, word) || bfs(i, j - 1, count, board, word) || bfs(i, j + 1, count, board, word);
        board[i][j] = temp;

        return ret;
    }
}
