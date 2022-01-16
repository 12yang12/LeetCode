package dynamicProgramming;

/**
 * 746. 使用最小花费爬楼梯
 */
public class LC746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        // 注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

}
