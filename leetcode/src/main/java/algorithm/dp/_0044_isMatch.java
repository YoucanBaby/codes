package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 06:42
 * @Description:
 */
public class _0044_isMatch {


    public boolean isMatch(String ss, String tt) {
        int M = ss.length();
        int N = tt.length();
        ss = ' ' + ss;
        tt = ' ' + tt;
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;

        for (int i = 0; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (t[j] != '*') {
                    dp[i][j] = (i - 1 >= 0) && dp[i - 1][j - 1] && (s[i] == t[j] || t[j] == '?');
                } else {
                    dp[i][j] = (i - 1 >= 0) && dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[M][N];
    }
}
