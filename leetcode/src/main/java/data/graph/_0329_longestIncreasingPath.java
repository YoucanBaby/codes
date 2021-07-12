package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 07:00
 * @Description:
 */
public class _0329_longestIncreasingPath {

    int[][] dirs = {
            {-1, 0}, {1, 0},
            {0, -1}, {0, 1}
    };
    int[][] matrix;
    int M;
    int N;
    int[][] visited;


    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        M = matrix.length;
        N = matrix[0].length;
        visited = new int[M][N];

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    public int dfs(int i, int j) {
        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        visited[i][j]++;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N) {
                if (matrix[i][j] < matrix[nextI][nextJ]) {
                    visited[i][j] = Math.max(visited[i][j], dfs(nextI, nextJ) + 1);
                }
            }
        }
        return visited[i][j];
    }
}
