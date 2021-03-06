package leetcode;

public class WildcardMatching {
    // https://leetcode.com/problems/wildcard-matching/

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') dp[i][0] = true;
            else break;
        }

        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                }
            }
        }

        printDp(dp);


        return dp[p.length()][s.length()];
    }

    private void printDp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
