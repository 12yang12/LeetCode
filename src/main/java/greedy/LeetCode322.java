package greedy;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode322 {

    /**
     * 暴力递归解法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，然后+1
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 自顶下下递归解法
     * 备忘录法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] memory = new int[amount + 1];
        // memory 数组全部初始化为特殊值
        Arrays.fill(memory, -666);

        return dp(coins, amount, memory);
    }

    private int dp(int[] coins, int amount, int[] memory) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 查备忘录，防止重复计算
        if (memory[amount] != -666) {
            return memory[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin, memory);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，然后+1
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memory[amount] = (res == Integer.MAX_VALUE) ? -1 : res;

        return memory[amount];
    }

    /**
     * 自底向上迭代法-DP
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        // dp数组的定义: 凑出金额amount，至少需要dp[amount]枚硬币
        int[] dp = new int[amount + 1];
        // dp 全部初始化为特殊值:amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层for循环在遍历所有状态的所有值
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                // 状态转移
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
