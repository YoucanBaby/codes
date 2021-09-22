package algorithm.presum;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-09-22 11:40
 * @Description:
 */
public class _1074_numSubmatrixSumTarget {


    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int M = mat.length, N = mat[0].length;
        int[][] sum = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] + mat[i][j] - sum[i][j];
            }
        }

        int res = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int p = 1; p <= i; p++) {
                    for (int q = 1; q <= j; q++) {
                        if (sum[i][j] - sum[i][q - 1] - sum[p - 1][j] + sum[p - 1][q - 1] == target) res++;
                    }
                }
            }
        }
        return res;
    }
}
