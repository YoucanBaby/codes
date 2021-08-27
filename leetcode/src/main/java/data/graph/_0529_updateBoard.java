package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 13:51
 * @Description:
 */
public class _0529_updateBoard {


    class Solution {
        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        char[][] mat;
        int M;
        int N;

        public char[][] updateBoard(char[][] mat, int[] click) {
            this.mat = mat;
            M = mat.length;
            N = mat[0].length;

            dfs(click[0], click[1]);
            return mat;
        }

        private void dfs(int x, int y) {
            if (mat[x][y] == 'M') {
                mat[x][y] = 'X';
                return;
            }
            if (mat[x][y] == 'X') {
                return;
            }

            int count = 0;
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (inArea(nextX, nextY) && mat[nextX][nextY] == 'M') {
                    count++;
                }
            }
            if (count > 0) {
                mat[x][y] = (char) (count + '0');
                return;
            } else {
                mat[x][y] = 'B';
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (inArea(nextX, nextY) && mat[nextX][nextY] == 'E') {
                        dfs(nextX, nextY);
                    }
                }
            }
        }

        // 当前节点是否在矩阵里
        private boolean inArea(int x, int y) {
            return x >= 0 && x < M && y >= 0 && y < N;
        }
    }
}
