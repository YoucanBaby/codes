package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 22:22
 * @Description:
 */
public class _0072_minDistance {


    public int minDistance(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
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
