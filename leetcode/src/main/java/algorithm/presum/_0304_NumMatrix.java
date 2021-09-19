package algorithm.presum;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 14:22
 * @Description:
 */
public class _0304_NumMatrix {


    class NumMatrix {

        int[][] s;

        public NumMatrix(int[][] mat) {
            int M = mat.length;
            int N = mat[0].length;
            s = new int[M + 1][N + 1];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + mat[i][j];
                }
            }
        }

        public int sumRegion(int x1, int y1, int x2, int y2) {
            return s[x2 + 1][y2 + 1] - s[x1][y2 + 1] - s[x2 + 1][y1] + s[x1][y1];
        }
    }
}
