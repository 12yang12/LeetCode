package dynamicProgramming;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 */
public class LC343 {

    public int integerBreak(int n) {
        // dp[i]为正整数i拆分结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // j*(i-j)代表把i拆分为j和i-j两个数相乘
                // j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }

        return dp[n];
    }

}
