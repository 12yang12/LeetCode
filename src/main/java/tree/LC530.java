package tree;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 */
public class LC530 {

    private int result = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);

        if (pre != null) {
            result = Math.min(result, root.val- pre.val) ;
        }
        pre = root;

        traversal(root.right);
    }
}
