package hashTable;

import java.util.HashMap;

public class LC1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                res[0] = map.get(difference);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}
