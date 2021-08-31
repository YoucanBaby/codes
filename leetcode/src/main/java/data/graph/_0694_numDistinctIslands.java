package data.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 03:02
 * @Description:
 */
public class _0694_numDistinctIslands {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    int[][] mat;
    int M;
    int N;

    public int numDistinctIslands(int[][] mat) {
        this.mat = mat;
        M = mat.length;
        N = mat[0].length;

        Set<String> path = new HashSet<>();
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(x, y, sb);
                    path.add(sb.toString());
                }
            }
        }
        return path.size();
    }

    private void dfs(int x, int y, StringBuilder sb) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }
        if (mat[x][y] == 0) {
            return;
        }

        mat[x][y] = 0;
        dfs(x - 1, y, sb.append("up"));
        dfs(x + 1, y, sb.append("down"));
        dfs(x, y - 1, sb.append("left"));
        dfs(x, y + 1, sb.append("right"));
    }
}
