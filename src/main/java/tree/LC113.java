package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class LC113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            // 如果和不为 targetsum 返回
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, path, res);
            // 回溯
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, targetSum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}
