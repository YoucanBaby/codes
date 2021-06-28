package data.array;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
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

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int r = 0;
        int c = cols;

        while (r <= rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
