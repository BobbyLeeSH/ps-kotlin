package leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0, indexL = 0, indexR = height.length - 1, maxL = height[indexL], maxR = height[indexR];
        while (true) {
            if (maxL < maxR) {
                indexL++;
                if (maxL < height[indexL]) maxL = height[indexL];
                else sum += (maxL - height[indexL]);
            } else {
                indexR--;
                if (maxR < height[indexR]) maxR = height[indexR];
                else sum += (maxR - height[indexR]);
            }

            if (indexL + 1 == indexR) break;
        }

        return sum;
    }
}
