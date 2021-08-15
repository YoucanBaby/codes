package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 10:48
 * @Description:
 */
public class _0074_searchMatrix {

    public boolean searchMatrix(int[][] mat, int target) {
        int M = mat.length;
        int N = mat[0].length;
        int x = M - 1;
        int y = 0;

        while (x >= 0 && y < N) {
            if (mat[x][y] == target) {
                return true;
            } else if (mat[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
