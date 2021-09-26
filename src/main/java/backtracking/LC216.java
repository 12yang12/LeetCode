package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class LC216 {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return result;
    }

    private void backtracking(int k, int targetSum, int curSum, int startIndex) {
        // 减枝
        if (curSum > targetSum) {
            return;
        }

        if (k == path.size()) {
            if (curSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            curSum += i;
            path.add(i);
            backtracking(k, targetSum, curSum, i + 1);
            //回溯
            curSum -= i;
            path.removeLast();
        }
    }
}
