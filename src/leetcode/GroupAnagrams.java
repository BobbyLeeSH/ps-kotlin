package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charsToSort = strs[i].toCharArray();
            Arrays.sort(charsToSort);
            String sorted = new String(charsToSort);

            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
