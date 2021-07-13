package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 11:34
 * @Description:
 */
public class _0200_numIslands {

    int[][] dirs = {
            {-1, 0}, {1, 0},    // 上下
            {0, -1}, {0 , 1}    // 左右
    };
    char[][] grid;
    int M;
    int N;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= M) {
            return;
        }
        if (j < 0 || j >= N) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        for (int k = 0; k < dirs.length; k++) {
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            dfs(nextI, nextJ);
        }
    }


}