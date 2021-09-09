package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-09 06:50
 * @Description:
 */
public class _0879_profitableSchemes {


    public int profitableSchemes(int V, int M, int[] v, int[] m) {
        int MOD = (int) (1e9 + 7);
        int N = v.length;
        long[][] dp = new long[V + 1][M + 1];
        for (int i = 0; i <= V; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= 0; k--) {
                    dp[j][k] += dp[j - v[i]][Math.max(0, k - m[i])];
                    dp[j][k] %= MOD;
                }
            }
        }
        return (int) dp[V][M];
    }
}
