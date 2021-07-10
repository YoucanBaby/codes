package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 13:23
 * @Description:
 */
public class _1034_colorBorder {

    int[][] grid;
    int M;
    int N;
    int newColor;
    int oldColor;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int newColor) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        this.newColor = newColor;
        this.oldColor = grid[r0][c0];

        dfs(r0, c0);
        return grid;
    }

    public void dfs(int i, int j) {
        // 如果碰到边界
        if (i == 0 && grid[i][j] == oldColor) {
            grid[i][j] = newColor;
            return;
        }
        if (i == M - 1 && grid[i][j] == oldColor) {
            grid[i][j] = newColor;
            return;
        }
        if (j == 0 && grid[i][j] == oldColor) {
            grid[i][j] = newColor;
            return;
        }
        if (j == N - 1 && grid[i][j] == oldColor) {
            grid[i][j] = newColor;
            return;
        }

        // 如果当前的
        // 没写完，不会啊！！
    }
}
