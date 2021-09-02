package algorithm.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 05:00
 * @Description:
 */
public class _1162_maxDistance {


    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int maxDistance(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;


        int[][] dist = new int[M][N];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == 1) {
                    deque.addLast(new int[] {x, y});
                }
            }
        }
        if (deque.size() == 0 || deque.size() == M * N) {
            return -1;
        }

        int res = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == 0) {
                    dist[nextX][nextY] = dist[x][y] + 1;
                    mat[nextX][nextY] = 1;
                    deque.addLast(new int[] {nextX, nextY});
                    res = Math.max(res, dist[nextX][nextY]);
                }
            }
        }
        return res;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
