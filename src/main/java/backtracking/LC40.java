package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 首先把给candidates排序，让其相同的元素都挨在一起。
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);

        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 要对同一树层使用过的元素进行跳过
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            // 和39.组合总和的区别，这里是i+1，每个数字在每个组合中只能使用一次
            backtracking(candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
