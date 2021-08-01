package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 22:20
 * @Description:
 */
public class _0188_maxProfit {

    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int N = prices.length;
        int[][] dp = new int[N][2 * K + 1];
        for (int j = 1; j <= 2 * K; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= 2 * K; j++) {
                if ((j & 1) == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[N - 1][2 * K];
    }
}
