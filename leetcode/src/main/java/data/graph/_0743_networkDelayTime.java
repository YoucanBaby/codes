package data.graph;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 01:12
 * @Description:
 */
public class _0743_networkDelayTime {


    public static void main(String[] args) {
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int N = 4;
        int K = 2;
        _0743_networkDelayTime solution = new _0743_networkDelayTime();

        System.out.println(solution.networkDelayTime(times, N, K));
    }


    List<List<int[]>> edges = new ArrayList<>();        // 源点：<汇点，长度>
    int[] dist;         // 路径长度

    public int networkDelayTime(int[][] times, int N, int K) {
        dist = new int[N + 1];          // 0不使用，实际范围是1~N
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int dst = times[i][1];
            int value = times[i][2];
            edges.get(src).add(new int[] {dst, value});
        }

        dfs(K, 0);
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // src源点，t是在t时间到达源点
    public void dfs(int src, int t) {
        if (dist[src] > t) {
            dist[src] = t;
            for (int[] edge : edges.get(src)) {
                int dst = edge[0];
                int value = edge[1];
                dfs(dst, t + value);
            }
        }
    }



    class Solution {

        public int networkDelayTime(int[][] times, int N, int K) {
            final int INF = (int) 1e7;
            int[][] edges = new int[N][N];          // 邻接矩阵
            for (int i = 0; i < N; i++) {
                Arrays.fill(edges[i], INF);
            }
            for (int[] t : times) {
                int src = t[0] - 1;             // 节点1~N，对应下标0~N-1
                int dst = t[1] - 1;
                edges[src][dst] = t[2];
            }

            int[] dist = new int[N];            // 所有路径的初始长度为无穷，K节点的长度为0
            Arrays.fill(dist, INF);
            dist[K - 1] = 0;
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                int src = -1;                    // 每次找到「最短距离最小」且「未被更新」的点 src
                for (int dst = 0; dst < N; dst++) {
                    if (!visited[dst] &&  (src == -1 || dist[src] > dist[dst])) {
                        src = dst;
                    }
                }
                visited[src] = true;            // 标记点 src 为已更新
                for (int dst = 0; dst < N; dst++) {     // 用点 dst 的「最小距离」更新其他点
                    dist[dst] = Math.min(dist[dst], dist[src] + edges[src][dst]);
                }
            }

            int maxDist = 0;
            for (int d : dist) {
                maxDist = Math.max(maxDist, d);
            }
            return maxDist == INF ? -1 : maxDist;
        }
    }
}
