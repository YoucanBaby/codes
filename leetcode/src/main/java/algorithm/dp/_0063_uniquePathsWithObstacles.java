package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-26 18:03
 * @Description:
 */
public class _0063_uniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            if (mat[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < N; j++) {
            if (mat[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[M - 1][N - 1];
    }
}
