package odd._260;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._260
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 10:33
 * @Description:
 */
public class _5882_gridGame {

    public static void main(String[] args) {
        _5882_gridGame solution = new _5882_gridGame();
        int[][] mat = {
                {3,3,1}, {8,5,2}
        };

        System.out.println(solution.gridGame(mat));
    }


    public long gridGame(int[][] mat) {
        int N = mat[0].length;
        if (N == 2) {
            return Math.min(mat[0][1], mat[1][0]);
        }

        long[] val0 = new long[N];
        val0[N - 1] = mat[0][N - 1];
        for (int i = N - 2; i >= 1; i--) {
            val0[i] = val0[i + 1] + mat[0][i];
        }

        long[] val1 = new long[N];
        val1[0] = mat[1][0];
        for (int i = 1; i <= N - 2; i++) {
            val1[i] = val1[i - 1] + mat[1][i];
        }

        long res = Long.MIN_VALUE;
        for (int i = 0; i <= N - 2; i++) {
            res = Math.max(res, Math.min(val0[i + 1], val1[i]));
        }
        return res;
    }
}
