package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeroCoords = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) zeroCoords.add(Arrays.asList(i, j));
            }
        }
        for (List<Integer> coord : zeroCoords) {
            for (int i=0; i< matrix.length; i++) {
                matrix[i][coord.get(1)] = 0;
            }
            for (int i=0; i< matrix[0].length; i++) {
                matrix[coord.get(0)][i] = 0;
            }
        }
    }
}
