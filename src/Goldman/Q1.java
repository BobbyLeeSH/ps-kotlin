package Goldman;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        for (int v : arr) {
            if (v == k) return "YES";
        }

        return "NO";
    }

    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 == 1) ret.add(i);
        }

        return ret;
    }

}
