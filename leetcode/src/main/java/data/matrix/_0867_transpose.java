package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 16:54
 * @Description:
 */
public class _0867_transpose {


    public int[][] transpose(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] res = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[j][i] = mat[i][j];
            }
        }
        return res;
    }
}
