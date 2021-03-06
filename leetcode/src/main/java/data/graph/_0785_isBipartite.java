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

    int[][] graph;
    int[] visited;      // -1，蓝色；0，未染色；1，红色

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        this.graph = graph;
        visited = new int[N];

        for (int src = 0; src < N; src++) {
            if (visited[src] == 0) {
                if (dfs(src, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int src, int color) {
        visited[src] = color;
        for (int dst : graph[src]) {
            if (visited[dst] == 0) {
                if (dfs(dst, -color) == false) {
                    return false;
                }
            }
            if (visited[src] == visited[dst]) {
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
