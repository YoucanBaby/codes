package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 19:55
 * @Description:
 */
public class _0583_minDistance {

    public int minDistance(String s, String t) {
        int M = s.length();
        int N = t.length();
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 2
                    );
                }
            }
        }
        return dp[M][N];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
