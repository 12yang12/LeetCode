package tree;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class LC538 {

    private int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    /**
     * 按右中左顺序遍历，累加即可
     *
     * @param root
     */
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.right);

        pre += root.val;
        root.val = pre;

        traversal(root.left);
    }
}
