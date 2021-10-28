package backtracking;

import java.util.*;

public class LC491 {

    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        // 使用数组来进行去重操作，题目说数值范围[-100, 100]
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            if (used[100 + nums[i]] == 1) {
                continue;
            }
            // 记录这个元素在本层用过了，本层后面不能再用了
            used[100 + nums[i]] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
