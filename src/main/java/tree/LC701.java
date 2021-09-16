package tree;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class LC701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
