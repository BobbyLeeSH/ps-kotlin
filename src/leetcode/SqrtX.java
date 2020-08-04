package leetcode;

public class SqrtX {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= 65536; i++) {
            double from = (double)i * (double)i;
            double to = ((double)i + 1) * ((double)i + 1);
            if (from <= x && to > x) return i;
        }
        return 0;
    }
}
