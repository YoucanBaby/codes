package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 17:51
 * @Description:
 */
public class _0785_isBipartite {

    int[] visited;      // 0,没有访问过,不染色; -1,染绿色; 1,染蓝色

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        visited = new int[N];

        // DFS
        for (int src = 0; src < N; src++) {
            // 如果没有访问过该源点，就做DFS，DFS返回false，我们就返回false
            if (visited[src] == 0) {
                if (!dfs(src, 1, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int src, int color, int[][] graph) {
        visited[src] = color;

        for (int dst : graph[src]) {
            // DFS
            if (visited[dst] == 0) {
                if (!dfs(dst, -color, graph)) {
                    return false;
                }
            }
            // 判断
            if (visited[dst] == visited[src]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] graph = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        _0785_isBipartite solution = new _0785_isBipartite();

        System.out.println(solution.isBipartite(graph));
    }
}
