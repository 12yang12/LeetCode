package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class LC94 {

    // 递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;

    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    // 迭代法
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                current = stack.removeLast();
                result.add(current.val);
                current = current.right;
            }
        }

        return result;
    }
}
