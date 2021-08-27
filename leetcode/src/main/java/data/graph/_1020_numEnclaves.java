package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 12:03
 * @Description:
 */
public class _1020_numEnclaves {

    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        int[][] mat;
        int M;
        int N;

        public int numEnclaves(int[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            // 淹没第一列和最后一列
            for (int x = 0; x < M; x++) {
                dfs(x, 0);
                dfs(x, N - 1);
            }
            // 淹没第一行和最后一行
            for (int y = 0; y < N; y++) {
                dfs(0, y);
                dfs(M - 1, y);
            }

            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (mat[x][y] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= M) {
                return;
            }
            if (y < 0 || y >= N) {
                return;
            }

            if (mat[x][y] == 1) {
                mat[x][y] = 0;
                for (int[] dir : dirs) {
                    dfs(x + dir[0], y + dir[1]);
                }
            }
        }
    }
}
