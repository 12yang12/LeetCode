package tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    // 递归: 左闭右闭 [left,right]
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);

        return root;
    }
}
