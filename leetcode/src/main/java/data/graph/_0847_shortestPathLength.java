package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-27 21:55
 * @Description:
 */
public class _0847_shortestPathLength {


    public int shortestPathLength(int[][] graph) {
        final int INF = (int) 0x3f3f3f3f;
        int N = graph.length;
        int mask = 1 << N;

        int[][] dist = new int[mask][N];
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dist[i], INF);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dist[1 << i][i] = 0;
            deque.addLast(new int[] {1 << i, i});
        }

        while (!deque.isEmpty()) {
            int[] temp = deque.removeFirst();
            int state = temp[0];
            int u = temp[1];
            int step = dist[state][u];
            if (state == mask - 1) {
                return step;
            }
            for (int i : graph[u]) {
                if (dist[state | (1 << i)][i] == INF) {
                    dist[state | (1 << i)][i] = step + 1;
                    deque.addLast(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1;
    }
}
