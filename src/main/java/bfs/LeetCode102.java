package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            while (queueSize > 0) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                queueSize--;
            }
            result.add(res);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        // DFS
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);

        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        if (root.left != null) {
            dfs(root.left, result, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, result, level + 1);
        }
    }
}

