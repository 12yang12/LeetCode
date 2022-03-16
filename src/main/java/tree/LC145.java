package tree;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 */
public class LC145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;

    }

    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }


    /**
     * 迭代法-后序遍历
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            result.add(node.val);

            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
