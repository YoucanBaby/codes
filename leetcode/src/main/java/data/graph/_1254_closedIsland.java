package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 02:48
 * @Description:
 */
public class _1254_closedIsland {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    int[][] mat;
    int M;
    int N;

    public int closedIsland(int[][] mat) {
        this.mat = mat;
        M = mat.length;
        N = mat[0].length;

        // 第一列和最后一列
        for (int x = 0; x < M; x++) {
            dfs(x, 0);
            dfs(x, N - 1);
        }
        // 第一行和最后一行
        for (int y = 0; y < N; y++) {
            dfs(0, y);
            dfs(M - 1, y);
        }

        int count = 0;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == 0) {
                    dfs(x, y);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }
        if (mat[x][y] == 1) {
            return;
        }

        mat[x][y] = 1;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }
}
