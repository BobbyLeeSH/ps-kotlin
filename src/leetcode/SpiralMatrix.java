package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // https://leetcode.com/problems/spiral-matrix/

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0) return ret;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int x = 0, y = 1, i = 0, j = 0;
        visited[i][j] = true;
        ret.add(matrix[0][0]);
        while (true) {
            if (x == 0) {
                if (j + y == -1 || j + y == matrix[0].length || visited[i][j + y]) {
                    x = y;
                    y = 0;
                    if (i + x == -1 || i + x == matrix.length || visited[i + x][j]) break;
                } else {
                    j += y;
                    ret.add(matrix[i][j]);
                    visited[i][j] = true;
                }
            } else {
                if (i + x == -1 || i + x == matrix.length || visited[i + x][j]) {
                    y = x * -1;
                    x = 0;
                    if (j + y == -1 || j + y == matrix[0].length || visited[i][j + y]) break;
                } else {
                    i += x;
                    ret.add(matrix[i][j]);
                    visited[i][j] = true;
                }
            }
        }

        return ret;
    }
}
