package divideAndConquer;

public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length - 1);
    }

    private int getMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMax = getMax(nums, left, mid);
        int rightMax = getMax(nums, mid + 1, right);
        int crossMax = getCrossMax(nums, left, right);

        return leftMax > rightMax ? Math.max(leftMax, crossMax)
                : Math.max(rightMax, crossMax);
    }

    private int getCrossMax(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int leftSum = nums[mid];
        int leftMax = leftSum;
        for (int i = mid - 1; i >= 0; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }

        int rightSum = nums[mid + 1];
        int rightMax = rightSum;
        for (int i = mid + 2; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return leftMax + rightMax;
    }
}
