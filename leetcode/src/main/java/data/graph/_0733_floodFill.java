package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 13:04
 * @Description:
 */
public class _0733_floodFill {

    class Solution {
        int[][] dirs = {
                {-1, 0}, {1, 0},    // 上下
                {0, -1}, {0 , 1}    // 左右
        };

        int[][] mat;
        int M;
        int N;

        public int[][] floodFill(int[][] mat, int sr, int sc, int newColor) {
            this.mat = mat;
            this.M = mat.length;
            this.N = mat[0].length;

            int oldColor = mat[sr][sc];
            if (oldColor == newColor) {
                return mat;
            }

            dfs(sr, sc, oldColor, newColor);
            return mat;
        }

        private void dfs(int x, int y, int oldColor, int newColor) {
            if (x < 0 || x >= M) {
                return;
            }
            if (y < 0 || y >= N) {
                return;
            }

            if (mat[x][y] == oldColor) {
                mat[x][y] = newColor;
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    dfs(nextX, nextY, oldColor, newColor);
                }
            }
        }
    }
}
