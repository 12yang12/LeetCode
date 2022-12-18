package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                if (map1.containsKey(i + j)) {
                    map1.put(i + j, 1 + map1.get(i + j));
                } else {
                    map1.put(i + j, 1);
                }
            }
        }

        int diff;
        for (int i : nums3) {
            for (int j : nums4) {
                diff = -(i + j);
                if (map1.containsKey(diff)) {
                    count += map1.get(diff);
                }
            }
        }

        return count;
    }
}
