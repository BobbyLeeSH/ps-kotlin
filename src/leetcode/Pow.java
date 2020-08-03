package leetcode;

public class Pow {
    // https://leetcode.com/problems/powx-n/

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return myPow(x * x, n / 2);
        if (n > 0) return myPow(x, n - 1) * x;
        return myPow(x, n + 1) / x;
    }
}
