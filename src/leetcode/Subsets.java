package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        find(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void find(int arr[], int ind, List<Integer> curr, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(curr));

        for (int i = ind; i < arr.length; i++) {
            curr.add(arr[i]);
            find(arr, i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
