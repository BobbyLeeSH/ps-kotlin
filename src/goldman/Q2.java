package goldman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {

    public static int countPairs(List<Integer> numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.getOrDefault(key + k, 0) > 0) {
                count++;
                map.put(key + k, map.get(key + k) - 1);
            }
        }

        return count;
    }

}
