package leetcode;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        long red = Arrays.stream(nums).filter(it -> it == 0).count();
        long white = Arrays.stream(nums).filter(it -> it == 1).count();

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i = (int) red; i < red + white; i++) {
            nums[i] = 1;
        }

        for (int i = (int) red + (int) white; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
