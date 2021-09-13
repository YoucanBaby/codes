package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-10 04:50
 * @Description:
 */
public class _0064_minPathSum {


    public int minPathSum(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = mat[0][0];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j - 1 >= 0 && i - 1 >= 0) {
                    dp[i][j] = mat[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                } else {
                    if (j - 1 >= 0) dp[i][j] = mat[i][j] + dp[i][j - 1];
                    if (i - 1 >= 0) dp[i][j] = mat[i][j] + dp[i - 1][j];
                }
            }
        }
        return dp[M - 1][N - 1];
    }
}
