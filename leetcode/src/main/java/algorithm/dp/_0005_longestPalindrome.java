package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-03 05:13
 * @Description:
 */
public class _0005_longestPalindrome {


    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        String res = "";

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
