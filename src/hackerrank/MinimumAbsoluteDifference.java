package hackerrank;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int min = Math.abs(sorted[0]-sorted[1]);
        for (int i = 1; i < arr.length - 1; i++) {
            min = Math.min(Math.abs(sorted[i]-sorted[i+1])  , min);
        }
        return min;
    }
}
