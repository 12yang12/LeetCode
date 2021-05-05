package divideAndConquer;

public class LeetCode169 {

    public int majorityElement(int[] nums) {
        return getMajority(nums, 0, nums.length - 1);
    }

    private int getMajority(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMajority = getMajority(nums, left, mid);
        int rightMajority = getMajority(nums, mid + 1, right);
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = 0;
        int rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == leftMajority) {
                leftCount++;
            } else if (nums[i] == rightMajority) {
                rightCount++;
            }
        }

        return leftCount > rightCount ? leftMajority : rightMajority;
    }
}

