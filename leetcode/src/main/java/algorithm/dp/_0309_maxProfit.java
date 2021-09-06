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
        int[][] dp = new int[N][3];
        
        dp[0][1] = -prices[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[N - 1][0], dp[N - 1][2]);
    }
}
