package tree;

/**
 * 654. 最大二叉树
 */
public class LC654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return traversal(nums, 0, nums.length);
    }

    private TreeNode traversal(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }

        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        int maxValueIndex = leftIndex;
        int maxValue = nums[maxValueIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValueIndex = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = traversal(nums, leftIndex, maxValueIndex);
        root.right = traversal(nums, maxValueIndex + 1, rightIndex);

        return root;
    }

}
