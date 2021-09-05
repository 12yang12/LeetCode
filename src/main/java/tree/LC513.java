package tree;

public class LC513 {
    private int maxDeep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);

        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (maxDeep < deep) {
                maxDeep = deep;
                value = root.val;
            }
        }

        if (root.left != null) {
            deep++;
            findLeftValue(root.left, deep);
            // 回溯
            deep--;
        }

        if (root.right != null) {
            // 隐藏着回溯
            findLeftValue(root.right, deep + 1);
        }
    }
}
