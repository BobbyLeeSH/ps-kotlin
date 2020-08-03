package leetcode;

public class JumpGame {
    // https://leetcode.com/problems/jump-game/

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        boolean[] dp = new boolean[nums.length];

        for (int j = nums.length - 2; j >= 0; j--) {
            if (j + nums[j] >= nums.length - 1) {
                dp[nums.length - 1] = true;
                break;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i && dp[i + 1]) {
                    dp[i] = true;
                    break;
                }
            }
            System.out.println(dp[i]);
        }
        for (int i = 1; i < nums[0]; i++) {
            if (dp[i]) {
                dp[0] = true;
                break;
            }
        }

        return dp[0];
    }
}
