package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 22:27
 * @Description:
 */
public class _0130_solve {



    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        char[][] mat;
        int M;
        int N;

        public void solve(char[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            // 遍历第0列和最后一列
            for (int x = 0; x < M; x++) {
                dfs(x, 0);
                dfs(x, N - 1);
            }
            // 遍历第0行和最后一行
            for (int y = 0; y < N; y++) {
                dfs(0, y);
                dfs(M - 1, y);
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (mat[x][y] == 'O') {
                        mat[x][y] = 'X';
                    } else if (mat[x][y] == 'B') {
                        mat[x][y] = 'O';
                    }
                }
            }
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= M) {
                return;
            }
            if (y < 0 || y >= N) {
                return;
            }

            if (mat[x][y] == 'O') {
                mat[x][y] = 'B';
                for (int[] dir : dirs) {
                    dfs(x + dir[0], y + dir[1]);
                }
            }
        }
    }
}
