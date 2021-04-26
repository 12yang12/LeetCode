package slidingWindow;

public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return res == nums.length + 1 ? 0 : res;
    }


}
