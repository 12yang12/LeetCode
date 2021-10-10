package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        // 先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);

        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        // 找到了数字和为 target 的组合
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            // 回溯，移除路径 path 最后一个元素
            path.remove(path.size() - 1);
        }
    }
}
