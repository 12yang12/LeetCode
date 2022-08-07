package dynamicProgramming;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LC121 {

    public int maxProfit(int[] prices) {
        // dp[i]表示截止到i，价格的最低点是多少
        // dp[i] = min(dp[i-1], prices[i])
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            maxProfit = Math.max(prices[i] - dp[i], maxProfit);
        }

        return maxProfit;
    }
}
