package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int v = map1.getOrDefault(i + j, 0);
                map1.put(i + j, ++v);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int diff = -(i + j);
                if (map1.containsKey(diff)) {
                    count += map1.get(diff);
                }
            }
        }

        return count;
    }
}
