package algorithm.dfs和bfs;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 02:57
 * @Description:
 */
public class _1293_shortestPath {

    public static void main(String[] args) {
        _1293_shortestPath solution = new _1293_shortestPath();
        int[][] mat = {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };
        int k = 1;

        solution.shortestPath(mat, k);
    }


    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };

    public int shortestPath(int[][] mat, int k) {
        int M = mat.length;
        int N = mat[0].length;
        if (M == 1 && N == 1) {
            return 0;
        }

        boolean[][][] visited = new boolean[M][N][k + 1];        // 位置到达[i,j]，还剩余k个消除障碍物的机会
        visited[0][0][k] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {0, 0, k});
        int minStep = 0;

        while (!deque.isEmpty()) {
            minStep++;

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] cur = deque.removeFirst();
                int x = cur[0];
                int y = cur[1];
                int remainCount = cur[2];       // 剩余次数

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (!inArea(mat, nextX, nextY)) {       // 越界
                        continue;
                    }
                    // 下个位置是空格，而且没访问过
                    if (mat[nextX][nextY] == 0 && !visited[nextX][nextY][remainCount]) {
                        if (nextX == M - 1 && nextY == N - 1) {
                            return minStep;
                        } else {
                            visited[nextX][nextY][remainCount] = true;
                            deque.addLast(new int[] {nextX, nextY, remainCount});
                        }
                    }
                    // 下个位置是障碍物，还有消除障碍物的次数，没有访问过下个状态
                    if (mat[nextX][nextY] == 1 && remainCount > 0 && !visited[nextX][nextY][remainCount - 1]) {
                        visited[nextX][nextY][remainCount - 1] = true;
                        deque.addLast(new int[] {nextX, nextY, remainCount - 1});
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
