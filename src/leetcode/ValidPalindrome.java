package leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            char c1 = str.charAt(start);
            while (true) {
                if (Character.isLetterOrDigit(c1)) break;
                if (start + 1 >= str.length()) return true;
                start++;
                c1 = str.charAt(start);
            }
            char c2 = str.charAt(end);
            while (true) {
                if (Character.isLetterOrDigit(c2)) break;
                if (end - 1 < 0) return true;
                end--;
                c2 = str.charAt(end);
            }
            if (c1 != c2) return false;

            start++;
            end--;
        }
        return true;
    }
}
