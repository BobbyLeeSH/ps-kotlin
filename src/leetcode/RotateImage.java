package leetcode;

public class RotateImage {
    // https://leetcode.com/problems/rotate-image/

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ret[i][j];
            }
        }
    }
}
