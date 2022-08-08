package twoPointers;

public class LC75 {

    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        // all in [0, p1) == 0
        // all in [p1, i) == 1
        // all in [p2, len - 1) == 2
        int p1 = 0;
        int i = 0;
        int p2 = nums.length - 1;

        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i++, p1++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
                swap(nums, i, p2--);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
