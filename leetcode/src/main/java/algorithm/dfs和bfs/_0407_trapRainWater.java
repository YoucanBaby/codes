package algorithm.dfs和bfs;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 04:36
 * @Description:
 */
public class _0407_trapRainWater {


    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int trapRainWater(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[M][N];
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (x == 0 || x == M - 1 || y == 0 || y == N - 1) {
                    pq.add(new int[] {x, y, mat[x][y]});
                    visited[x][y] = true;
                }
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int x = cur[0];
            int y = cur[1];
            int h = cur[2];     // 高度

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (inArea(mat, nextX, nextY) && !visited[nextX][nextY]) {
                    if (mat[nextX][nextY] < h) {
                        res += h - mat[nextX][nextY];
                    }
                    pq.add(new int[] {nextX, nextY, Math.max(h, mat[nextX][nextY])});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return res;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
