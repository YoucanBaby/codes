package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 12:03
 * @Description:
 */
public class _1020_numEnclaves {

    int[][] grid;
    int M;
    int N;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;

        // 淹没第一列和最后一列
        for (int i = 0; i < M; i++) {
            dfs(i, 0);
            dfs(i, N - 1);
        }

        // 淹没第一行和最后一行
        for (int j = 0; j < N; j++) {
            dfs(0, j);
            dfs(M - 1, j);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        // 上
        if (i >= 1) {
            dfs(i - 1, j);
        }
        // 下
        if (i <= M - 2) {
            dfs(i + 1, j);
        }
        // 左
        if (j >= 1) {
            dfs(i, j - 1);
        }
        // 右
        if (j <= N - 2) {
            dfs(i, j + 1);
        }
    }
}
