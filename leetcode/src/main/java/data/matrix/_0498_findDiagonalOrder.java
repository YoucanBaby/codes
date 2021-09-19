package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 16:14
 * @Description:
 */
public class _0498_findDiagonalOrder {


    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int M = mat.length;
        int N = mat[0].length;
        int[] res = new int[M * N];
        int index = 0;
        int x = 0, y = 0;
        for (int k = 0; k < M + N - 1; k++) {
            if ((k & 1) == 0) {
                while (x >= 0 && y < N) {
                    res[index++] = mat[x--][y++];
                }
                if (y < N) {
                    x += 1;
                } else {
                    x += 2;
                    y -= 1;
                }
            } else {
                while (x < M && y >= 0) {
                    res[index++] = mat[x++][y--];
                }
                if (x < M) {
                    y += 1;
                } else {
                    x -= 1;
                    y += 2;
                }
            }
        }
        return res;
    }
}
