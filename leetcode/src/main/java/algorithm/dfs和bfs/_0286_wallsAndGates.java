package algorithm.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 01:36
 * @Description:
 */
public class _0286_wallsAndGates {

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0, 1}
    };
    final int EMPTY = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        Deque<int[]> deque = new ArrayDeque<>();
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == 0) {
                    deque.addLast(new int[] {x, y});
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == EMPTY) {
                    mat[nextX][nextY] = mat[x][y] + 1;
                    deque.addLast(new int[] {nextX, nextY});
                }
            }
        }
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
