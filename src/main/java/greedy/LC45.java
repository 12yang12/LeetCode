package greedy;

public class LC45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 当前覆盖最远距离下标
        int curDistance = 0;
        // 记录走的最大步数
        int ans = 0;
        // 下一步覆盖最远距离下标
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);
            // 遇到当前覆盖最远距离下标
            if (i == curDistance) {
                // 如果当前覆盖最远距离下标不是终点,需要走下一步,更新当前覆盖最远距离下标
                if (curDistance != nums.length - 1) {
                    ans++;
                    curDistance = nextDistance;
                    // 下一步的覆盖范围已经可以达到终点，结束循环
                    if (nextDistance >= nums.length - 1) {
                        break;
                    }
                } else {
                    // 当前覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
                    break;
                }
            }
        }

        return ans;
    }
}
