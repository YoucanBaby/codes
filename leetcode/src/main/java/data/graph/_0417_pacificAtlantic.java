package data.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 22:05
 * @Description:
 */
public class _0417_pacificAtlantic {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };
    int[][] mat;
    int M;
    int N;
    boolean[][] pVisited;
    boolean[][] aVisited;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        this.mat = mat;
        this.M = mat.length;
        this.N = mat[0].length;
        pVisited = new boolean[M][N];
        aVisited = new boolean[M][N];

        for (int y = 0; y < N; y++) {       // 第0行和最后一行
            dfs(pVisited, 0, y);
            dfs(aVisited, M - 1, y);
        }
        for (int x = 0; x < M; x++) {       // 第0列最后一列
            dfs(pVisited, x, 0);
            dfs(aVisited, x, N - 1);
        }
        return res;
    }

    private void dfs(boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        if (pVisited[x][y] && aVisited[x][y]) {
            res.add(Arrays.asList(x, y));
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (inArea(nextX, nextY) && mat[nextX][nextY] >= mat[x][y]) {
                dfs(visited, nextX, nextY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
