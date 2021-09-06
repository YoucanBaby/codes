package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-06 01:46
 * @Description:
 */
public class _0664_strangePrinter {


    public int strangePrinter(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;

                dp[i][j] = dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}
