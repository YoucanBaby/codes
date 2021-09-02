package algorithm.dfs和bfs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 02:31
 * @Description:
 */
public class _0542_updateMatrix {

    public static void main(String[] args) {
        _0542_updateMatrix solution = new _0542_updateMatrix();
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int[][] res = solution.updateMatrix(mat);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int[][] step = new int[M][N];
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

                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == 1) {
                    step[nextX][nextY] = step[x][y] + 1;
                    mat[nextX][nextY] = 0;
                    deque.addLast(new int[] {nextX, nextY});
                }
            }
        }
        return step;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
