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

    // 八连通
    int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},     // 第一行
            {0, -1},           {0, 1},      // 第二行
            {1, -1}, {1, 0}, {1, 1},        // 第三行
    };
    int[][] grid;
    int M;
    int N;
    boolean[][] visited;
    int[][] dis;        // 记录到原点的距离

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        visited = new boolean[M][N];
        dis = new int[M][N];

        // 排除特殊情况
        if (grid[0][0] == 1) {
            return -1;
        }
        if (M == 1 && N == 1) {
            return 1;
        }

        return bfs();
    }

    public int bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        visited[0][0] = true;
        dis[0][0] = 1;

        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();
            // 一维坐标转二维坐标
            int curI = cur / N;
            int curJ = cur % N;
            for (int k = 0; k < dirs.length; k++) {
                int nextI = curI + dirs[k][0];
                int nextJ = curJ + dirs[k][1];

                // 如果下个节点没有越界，没有访问过，而且值是0
                if (inArea(nextI, nextJ) && !visited[nextI][nextJ] && grid[nextI][nextJ] == 0) {
                    // 二维坐标转一维坐标
                    int next = nextI * N + nextJ;
                    // 更新队列，更新visited，更新dis
                    deque.addLast(next);
                    visited[nextI][nextJ] = true;
                    dis[nextI][nextJ] = dis[curI][curJ] + 1;

                    if (nextI == M - 1 && nextJ == N - 1) {
                        return dis[nextI][nextJ];
                    }
                }
            }
        }

        return -1;
    }

    public boolean inArea(int nextI, int nextJ) {
        if (nextI < 0 || nextI >= M) {
            return false;
        }
        if (nextJ < 0 || nextJ >= N) {
            return false;
        }
        return true;
    }

}
