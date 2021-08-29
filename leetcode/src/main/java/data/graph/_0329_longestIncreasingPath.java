package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 07:00
 * @Description:
 */
public class _0329_longestIncreasingPath {


    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},
                {0, -1}, {0, 1}
        };

        int[][] mat;
        int M;
        int N;
        int[][] visited;

        public int longestIncreasingPath(int[][] mat) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;
            visited = new int[M][N];

            int res = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (visited[x][y] == 0) {
                        res = Math.max(res, dfs(x, y));
                    }
                }
            }
            return res;
        }

        public int dfs(int x, int y) {
            if (visited[x][y] == 0) {
                visited[x][y] = 1;
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (inArea(nextX, nextY) && mat[nextX][nextY] > mat[x][y]) {
                        visited[x][y] = Math.max(visited[x][y], dfs(nextX, nextY) + 1);
                    }
                }
            }
            return visited[x][y];
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < M && y >= 0 && y < N;
        }
    }
}
