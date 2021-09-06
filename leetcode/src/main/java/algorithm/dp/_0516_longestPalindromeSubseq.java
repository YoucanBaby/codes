package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-03 05:27
 * @Description:
 */
public class _0516_longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
