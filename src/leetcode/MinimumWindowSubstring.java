package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) return "";
        Map<Character, Long> tMap = t.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> sMap = new HashMap<>();
        sMap.put(s.charAt(0), 1L);
        int start = 0, end = 1;
        String ret = "";
        while (true) {
            if (contains(tMap, sMap)) {
                String curr = s.substring(start, end);
                if (curr.length() < ret.length() || ret.equals("")) ret = curr;
                char c = s.charAt(start);
                sMap.put(c, sMap.get(c) - 1);
                start += 1;
            } else {
                if (end >= s.length()) break;
                char c = s.charAt(end);
                sMap.put(c, sMap.getOrDefault(c, 0L) + 1);
                end += 1;
            }
        }
        return ret;
    }

    private boolean contains(Map<Character, Long> tMap, Map<Character, Long> sMap) {
        for (char c : tMap.keySet()) {
            if (tMap.get(c) > sMap.getOrDefault(c, 0L)) return false;
        }
        return true;
    }
}
