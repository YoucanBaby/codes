package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 10:19
 * @Description:
 */
public class _0695_maxAreaOfIsland {

    int[][] grid;
    int M;
    int N;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int temp = dfs(i, j);
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public int dfs(int i, int j) {
        if (i < 0 || i >= M) {
            return 0;
        }
        if (j < 0 || j >= N) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        } else {
            grid[i][j] = 0;
            return 1
                    + dfs(i - 1, j)     // 上
                    + dfs(i, j + 1)     // 右
                    + dfs(i + 1, j)     // 下
                    + dfs(i, j - 1);    // 左
        }
    }


    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        int[][] mat;
        int M;
        int N;

        public int maxAreaOfIsland(int[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            int max = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    int res = dfs(x, y);
                    max = Math.max(max, res);
                }
            }
            return max;
        }

        private int dfs(int x, int y) {
            if (x < 0 || x >= M) {
                return 0;
            }
            if (y < 0 || y >= N) {
                return 0;
            }

            int count = 0;
            if (mat[x][y] == 1) {
                mat[x][y] = 0;
                count++;
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    count += dfs(nextX, nextY);
                }
            }
            return count;
        }
    }
}
