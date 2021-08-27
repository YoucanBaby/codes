package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 11:25
 * @Description:
 */
public class _0463_islandPerimeter {


    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        int[][] mat;
        int M;
        int N;

        public int islandPerimeter(int[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (mat[x][y] == 1) {
                        return dfs(x, y);       // 只有一个岛屿
                    }
                }
            }
            return 0;
        }

        private int dfs(int x, int y) {
            if (x < 0 || x >= M || y < 0 || y >= N) {
                return 1;
            }
            if (mat[x][y] == 0) {
                return 1;
            }

            int count = 0;
            if (mat[x][y] == 1) {
                mat[x][y] = 2;
                for (int[] dir : dirs) {
                    count += dfs(x + dir[0], y + dir[1]);
                }
            }
            return count;
        }
    }
}
