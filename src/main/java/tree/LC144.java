package tree;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    /**
     * 迭代法-前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            result.add(node.val);
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return result;
    }
}
