package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 04:07
 * @Description:
 */
public class _0718_findLength {


    public int findLength(int[] A, int[] B) {
        int M = A.length;
        int N = B.length;
        int[][] dp = new int[M + 1][N + 1];

        int max = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // 滚动数组
    public int findLength1(int[] A, int[] B) {
        int M = A.length;
        int N = B.length;
        int[] dp = new int[N + 1];

        int max = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = N; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;      // 更新dp数组，不相等要赋值为0
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
