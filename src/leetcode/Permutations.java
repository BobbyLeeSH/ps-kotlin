package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> FINAL = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        perm(nums, new ArrayList<>());

        return FINAL;
    }

    private void perm(int[] original, ArrayList<Integer> curr) {
        if (curr.size() == original.length) {
            FINAL.add(curr);
            return;
        }

        for (int i = 0; i < original.length; i++) {
            ArrayList<Integer> next = (ArrayList<Integer>) curr.clone();

            if (!next.contains(original[i])) {
                next.add(original[i]);
                perm(original, next);
            }
        }
    }
}
