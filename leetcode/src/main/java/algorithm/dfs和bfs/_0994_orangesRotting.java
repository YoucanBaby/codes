package algorithm.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 02:06
 * @Description:
 */
public class _0994_orangesRotting {

    public static void main(String[] args) {
        _0994_orangesRotting solution = new _0994_orangesRotting();
        int[][] mat = {
                {2,1,1}, {1,1,0}, {0,1,1}
        };
        System.out.println(solution.orangesRotting(mat));
    }

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int orangesRotting(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        Deque<int[]> deque = new ArrayDeque<>();
        int freshCount = 0;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == 1) {
                    freshCount++;
                }
                if (mat[x][y] == 2) {
                    deque.addLast(new int[] {x, y});
                }
            }
        }

        int res = 0;
        int[][] step = new int[M][N];
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == 1) {
                    mat[nextX][nextY] = 2;
                    step[nextX][nextY] = step[x][y] + 1;
                    res = Math.max(res, step[nextX][nextY]);
                    freshCount--;
                    deque.addLast(new int[] {nextX, nextY});
                }
            }
        }
        return freshCount == 0 ? res : -1;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
