package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 */
public class LC104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int size = 0;
        while (!deque.isEmpty()) {
            size = deque.size();
            depth++;
            while (size-- > 0) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }
        }
        return depth;
    }
}
