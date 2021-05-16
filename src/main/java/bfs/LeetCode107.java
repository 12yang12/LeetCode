package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 */
public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<ArrayList<Integer>> temp = new LinkedList<>();

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
            temp.addFirst(res);
        }
        result = new ArrayList<>(temp);

        return result;
    }
}


