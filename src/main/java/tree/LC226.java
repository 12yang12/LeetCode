package tree;

/**
 *  226. 翻转二叉树
 */
public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
