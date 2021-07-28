package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 14:17
 * @Description:
 */
public class _0047_maxValue {

    public int maxValue(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int value = mat[i - 1][j- 1];
                dp[i][j] = Math.max(dp[i - 1][j] + value, dp[i][j - 1] + value);
            }
        }

        return dp[M][N];
    }

    public int maxValue1(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int[] dp = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int value = mat[i - 1][j- 1];
                dp[j] = Math.max(dp[j - 1] + value, dp[j] + value);
            }
        }

        return dp[N];
    }
}
