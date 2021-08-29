package data.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 19:30
 * @Description:
 */
public class _1091_shortestPathBinaryMatrix {


    class Solution {
        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        public int shortestPathBinaryMatrix(int[][] mat) {
            int N = mat.length;
            boolean[][] visited = new boolean[N][N];
            int[][] dist = new int[N][N];           // 当前节点到原点的距离

            if (mat[0][0] == 1) {                   // 特殊情况
                return -1;
            }
            if (N == 1) {
                return 1;
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(new int[] {0,0});
            visited[0][0] = true;
            dist[0][0] = 1;

            while (!deque.isEmpty()) {
                int[] cur = deque.removeFirst();
                int x = cur[0];
                int y = cur[1];

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    // 如果下个节点没有越界，没有访问过，而且值是0
                    if (inArea(nextX, nextY, N) && !visited[nextX][nextY] && mat[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        deque.addLast(new int[] {nextX, nextY});
                        dist[nextX][nextY] = dist[x][y] + 1;

                        if (nextX == N - 1 && nextY == N - 1) {
                            return dist[nextX][nextY];
                        }
                    }
                }
            }
            return -1;
        }

        private boolean inArea(int x, int y, int N) {
            return x >= 0 && x < N && y >= 0 && y < N;
        }
    }
}
