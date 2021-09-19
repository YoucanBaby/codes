package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 11:50
 * @Description:
 */
public class _0073_setZeroes {

    public void setZeroes(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        boolean flagRow0 = false;
        for (int j = 0; j < N; j++) {
            if (mat[0][j] == 0) flagRow0 = true;
        }

        boolean flagCol0 = false;
        for (int i = 0; i < M; i++) {
            if (mat[i][0] == 0) flagCol0 = true;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (flagRow0) {
            for (int j = 0; j < N; j++) {
                mat[0][j] = 0;
            }
        }
        if (flagCol0) {
            for (int i = 0; i < M; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
