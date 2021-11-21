package greedy;

public class LC55 {
    public boolean canJump(int[] nums) {
        // 只有一个元素，就是能达到
        if (nums.length == 1) {
            return true;
        }

        int cover = 0;
        // 注意这里是小于等于cover
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            // 说明可以覆盖到终点了
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
