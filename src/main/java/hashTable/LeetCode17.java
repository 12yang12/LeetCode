package hashTable;

import java.util.*;

public class LeetCode17 {

    public boolean containsDuplicate(int[] nums) {
        // 排序法
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return  true;
            }
        }
        return  false;

        // 集合法
        //Set<Integer> set = new HashSet<Integer>();
        //for (int x : nums) {
        //    if (!set.add(x)) {
        //        return true;
        //    }
        //}
        // 哈希表法
        //Map<Integer, Integer> map = new HashMap<>();
        //for (int num : nums) {
        //    if (map.containsKey(num)) {
        //        map.put(num, 1 + map.get(num));
        //    } else {
        //        map.put(num, 1);
        //    }
        //}
        //for (Integer value : map.values()) {
        //    if (value.intValue() > 1 ) {
        //        return true;
        //    }
        //}
        //return false;
    }

}
