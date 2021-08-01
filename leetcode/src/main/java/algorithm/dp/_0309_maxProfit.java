package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 18:12
 * @Description:
 */
public class _0309_maxProfit {


    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < N; i++) {
            int temp = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], temp);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[N - 1][1], Math.max(dp[N - 1][2], dp[N - 1][3]));
    }
}
