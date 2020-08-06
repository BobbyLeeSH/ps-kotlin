package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<List<Integer>> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (stack.isEmpty() || stack.peek().get(1) <= height) {
                stack.push(Arrays.asList(i, height));
            } else {
                int idx = i;
                while (!stack.isEmpty() && stack.peek().get(1) > height) {
                    List<Integer> curr = stack.pop();
                    int area = (i - curr.get(0)) * curr.get(1);
                    System.out.println(area);
                    max = Math.max(max, area);
                    idx = curr.get(0);
                }
                stack.push(Arrays.asList(idx, height));
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> curr = stack.pop();
            int area = (heights.length - curr.get(0)) * curr.get(1);
            System.out.println(area);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangleAreaNotOptimal(int[] heights) {
        if (heights.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i, end = i, curr = heights[i];

            while (start > 0) {
                if (heights[start - 1] >= curr) start--;
                else break;
            }

            while (end < heights.length - 1) {
                if (heights[end + 1] >= curr) end++;
                else break;
            }

            max = Math.max(max, (end - start + 1) * curr);
        }
        return max;
    }
}
