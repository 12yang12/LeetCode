package backtracking;

import java.util.*;

public class LC90 {
    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            // 对同一树层使用过的元素进行跳过
            if (i > startIndex && nums[i] == nums[i - 1] ) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
