package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 21:44
 * @Description:
 */
public class _0714_maxProfit {


    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[][] dp = new int[N][2];

        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[N - 1][0];
    }
}
