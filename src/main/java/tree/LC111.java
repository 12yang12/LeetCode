package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 */
public class LC111 {

    public int minDepth(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offerFirst(root);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            while (size-- > 0) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
            }
        }

        return depth;
    }
}
