package tree;

/**
 * 669. 修剪二叉搜索树
 */
public class LC669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 寻找符合区间[low, high]的节点
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // root->left接入符合条件的左孩子
        root.left = trimBST(root.left, low, high);
        // root->right接入符合条件的右孩子
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
