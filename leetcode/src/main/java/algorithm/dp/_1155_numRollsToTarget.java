package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-03 06:40
 * @Description:
 */
public class _1155_numRollsToTarget {

    // N个骰子，每个骰子有M面，要投掷出的总和为target
    public int numRollsToTarget(int N, int M, int target) {
        long MOD = (long) (1e9 + 7);
        long[][] dp = new long[N + 1][target + 1];
        dp[0][0] = 1;

        // 枚举物品
        for (int i = 1; i <= N; i++) {
            // 枚举背包容量
            for (int j = 1; j <= target; j++) {
                // 枚举骰子能投出去的点数
                for (int k = 1; k <= M; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        return (int) dp[N][target];
    }
}
