package tree;

/**
 *  226. 翻转二叉树
 */
public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历位置
        // root 节点需要交换它的左右子节点
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
