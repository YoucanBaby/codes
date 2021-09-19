package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 15:02
 * @Description:
 */
public class _0059_generateMatrix {

    public static void main(String[] args) {
        _0059_generateMatrix solution = new _0059_generateMatrix();

        System.out.println(solution.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int j = l; j <= r; j++) res[u][j] = num++;
            u++;
            for (int i = u; i <= d; i++) res[i][r] = num++;
            r--;
            for (int j = r; j >= l; j--) res[d][j] = num++;
            d--;
            for (int i = d; i >= u; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }
}
