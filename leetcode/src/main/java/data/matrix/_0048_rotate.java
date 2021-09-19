package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 14:47
 * @Description:
 */
public class _0048_rotate {



    public void rotate(int[][] mat) {
        int N = mat.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[N - i - 1][j];
                mat[N - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
