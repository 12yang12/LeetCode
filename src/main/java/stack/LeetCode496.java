package stack;

import java.util.*;

public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2,把对应关系存入哈希表
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peekLast()) {
                map.put(stack.pollLast(), num);
            }
            stack.addLast(num);
        }
        // 遍历 nums1 得到结果集
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] result = new LeetCode496().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }

}
