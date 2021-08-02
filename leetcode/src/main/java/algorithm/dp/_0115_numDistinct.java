package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 07:51
 * @Description:
 */
public class _0115_numDistinct {

    public int numDistinct(String s, String t) {
        int M = s.length();
        int N = t.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }
}
