package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 12:06
 * @Description:
 */
public class _0240_searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        _0240_searchMatrix solution = new _0240_searchMatrix();

        System.out.println(solution.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int M = mat.length;
        int N = mat[0].length;
        int x = 0;
        int y = N - 1;

        while (x < M && y >= 0) {
            if (mat[x][y] == target) {
                return true;
            } else if (mat[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
