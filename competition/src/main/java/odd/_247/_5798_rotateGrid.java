package odd._247;

import java.util.Arrays;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 11:30
 * @Description:
 */
public class _5798_rotateGrid {

    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int k = 2;
        _5798_rotateGrid solution = new _5798_rotateGrid();

        int[][] res = solution.rotateGrid(grid, k);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int M = grid.length;
        int N = grid[0].length;

        int num = 2 * (M - 1) + 2 * (N - 1);
        k = k % num;

        for (int a = 0; a < k; a++) {

            int left = 0;
            int right = N - 1;
            int up = 0;
            int down = M - 1;

            while (left < right && up < down) {
                int tempLeft = grid[down][left];
                int tempDown = grid[down][right];
                int tempRight = grid[up][right];
                int tempUp = grid[up][left];

                // 左边从上向下移动
                for (int i = down; i >= up + 2; i--) {
                    grid[i][left] = grid[i - 1][left];
                }

                // 下边从左向右移动
                for (int j = right; j >= left + 2; j--) {
                    grid[down][j] = grid[down][j - 1];
                }

                // 右边从下向上移动
                for (int i = up; i <= down - 2; i++) {
                    grid[i][right] = grid[i + 1][right];
                }

                // 上边从左向右移动
                for (int j = left; j <= right - 2; j++) {
                    grid[up][j] = grid[up][j + 1];
                }

                grid[down][left + 1] = tempLeft;
                grid[down - 1][right] = tempDown;
                grid[up][right - 1] = tempRight;
                grid[up + 1][left] = tempUp;

                left++;
                right--;
                up++;
                down--;
            }
        }
        return grid;
    }
}
