package tree;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 */
public class LC107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelQueueSize = queue.size();

            while (levelQueueSize > 0) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelQueueSize--;
            }

            resultList.add(levelList);
        }

        Collections.reverse(resultList);

        return resultList;
    }
}
