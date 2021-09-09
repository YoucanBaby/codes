package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 04:10
 * @Description:
 */
public class _0010_isMatch {


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
                if (j + 1 <= N && t[j + 1] == '*') {        // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                    continue;
                }

                if (i - 1 >= 0 && t[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s[i] == t[j] || t[j] == '.');
                }

                else if (t[j] == '*') {
                    dp[i][j] = (j - 2 >= 0) && dp[i][j - 2]
                            || (i - 1 >= 0) && dp[i - 1][j] && (s[i] == t[j - 1] || t[j - 1] == '.');
                }
            }
        }
        return dp[M][N];
    }
}
