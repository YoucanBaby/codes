package data.array;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 11:28
 * @Description:
 */
public class _0566_matrixReshape {
    public static void main(String[] args) {
        int[][] mat = {    {1,2},
                            {3,4}};
        int r = 1;
        int c = 4;
        _0566_matrixReshape solution = new _0566_matrixReshape();

        int[][] reshapeMat = solution.matrixReshape(mat, r, c);
        for (int i = 0; i < reshapeMat.length; i++) {
            System.out.println(Arrays.toString(reshapeMat[i]));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c)
            return mat;

        int[][] reshapeMat = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeMat[i][j] = mat[index / n][index % n];
                index++;
            }
        }
        return reshapeMat;
    }
}
