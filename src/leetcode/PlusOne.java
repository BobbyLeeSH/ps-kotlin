package leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        return increment(digits, digits.length - 1);
    }

    private int[] increment(int[] digits, int index) {
        if (digits[index] == 9) {
            digits[index] = 0;
            index--;
            if (index < 0) {
                int[] ret = new int[digits.length + 1];
                ret[0] = 1;
                for (int i = 1; i < ret.length; i++) {
                    ret[i] = digits[i - 1];
                }
                return ret;
            }
            return increment(digits, index);
        } else {
            digits[index]++;
            return digits;
        }
    }
}
