package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 04:00
 * @Description:
 */
public class _0766_isToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        _0766_isToeplitzMatrix solution = new _0766_isToeplitzMatrix();

        System.out.println(solution.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] mat) {
        for (int i = 0; i < mat.length - 1; i++) {
            for (int j = 0; j < mat[0].length - 1; j++) {
                if (mat[i][j] != mat[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
