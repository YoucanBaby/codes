package algorithm.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 21:29
 * @Description:
 */
public class _0317_shortestDistance {


    public static void main(String[] args) {
        _0317_shortestDistance solution = new _0317_shortestDistance();
        int[][] mat = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(solution.shortestDistance(mat));
    }

    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int shortestDistance(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int[][] totalDist = new int[M][N];
        int[][] dist = new int[M][N];
        for (int i = 0; i < M; i++) {
            totalDist[i] = Arrays.copyOf(mat[i], N);
            dist[i] = Arrays.copyOf(mat[i], N);
        }

        int val = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    res = bfs(mat, totalDist, dist, i, j, val);
                    val--;
                }
            }
        }
        for (int i = 0; i < totalDist.length; i++) {
            System.out.println(Arrays.toString(totalDist[i]));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int bfs(int[][] mat, int[][] totalDist, int[][] dist, int startX, int startY, int val) {
        int res = Integer.MAX_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {startX, startY});

        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (inArea(mat, nextX, nextY) && mat[nextX][nextY] == val) {
                    mat[nextX][nextY]--;
                    dist[nextX][nextY] = dist[x][y] + 1;
                    totalDist[nextX][nextY] += dist[nextX][nextY] - 1;
                    deque.addLast(new int[] {nextX, nextY});
                    res = Math.min(res, totalDist[nextX][nextY]);
                }
            }
        }
        return res;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
