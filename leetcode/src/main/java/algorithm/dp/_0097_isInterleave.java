package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-10 13:43
 * @Description:
 */
public class _0097_isInterleave {


    public static void main(String[] args) {
        _0097_isInterleave solution = new _0097_isInterleave();

//        String ss1 = "aabcc";
//        String ss2 = "dbbca";
//        String ss3 = "aadbbcbcac";
        String ss1 = "db";
        String ss2 = "b";
        String ss3 = "cbb";
        System.out.println(solution.isInterleave(ss1, ss2, ss3));
    }

    public boolean isInterleave(String ss1, String ss2, String ss3) {
        if (ss1.length() + ss2.length() != ss3.length()) {
            return false;
        }

        int M = ss1.length();
        int N = ss2.length();
        ss1 = " " + ss1;
        ss2 = " " + ss2;
        ss3 = " " + ss3;
        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();
        char[] s3 = ss3.toCharArray();

        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 1; i <= M && s1[i] == s3[i]; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= N && s2[j] == s3[j]; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] |= dp[i - 1][j] && s3[i + j] == s1[i];
                dp[i][j] |= dp[i][j - 1] && s3[i + j] == s2[j];
            }
        }
        return dp[M][N];
    }
}
