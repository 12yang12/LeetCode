package tree;

public class LC112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return traversal(root, targetSum - root.val);
    }

    private boolean traversal(TreeNode root, int sum) {
        // 遇到叶子节点直接返回
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        if (root.left != null) {
            if (traversal(root.left, sum - root.left.val)) {
                return true;
            }
        }

        if (root.right != null) {
            return traversal(root.right, sum - root.right.val);
        }

        return false;
    }
}
