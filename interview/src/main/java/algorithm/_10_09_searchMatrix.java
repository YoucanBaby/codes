package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 10:46
 * @Description:
 */
public class _10_09_searchMatrix {


    public boolean searchMatrix(int[][] mat, int target) {
        if (mat.length == 0) {
            return false;
        }
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
