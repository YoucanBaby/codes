package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-10 04:13
 * @Description:
 */
public class _0221_maximalSquare {


    public int maximalSquare(char[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] dp = new int[M][N];

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (!inArea(mat, i - 1, j - 1)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = min(dp, i, j) + 1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    // 获得左边，左上，上边，边长的最小值
    private int min(int[][] dp, int i, int j) {
        int a = dp[i- 1][j - 1];
        int b = dp[i][j - 1];
        int c = dp[i- 1][j];
        return Math.min(a, Math.min(b, c));
    }

    private boolean inArea(char[][] mat, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length;
    }
}
