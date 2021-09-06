package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-26 16:59
 * @Description:
 */
public class _0062_uniquePaths {

    public int uniquePaths(int M, int N) {
        int[][] dp = new int[M][N];

        dp[0][0] = 1;
        for (int i = 1; i < M; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < N; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[M - 1][N - 1];
    }

    public int uniquePaths1(int M, int N) {
        int[] dp = new int[N];
        for (int j = 0; j < N; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[j] = dp[j] +  dp[j - 1];
            }
        }

        return dp[N - 1];
    }
}
