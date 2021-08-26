package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-11 21:16
 * @Description:
 */
public class _0323_countComponents {

    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;

    public int countComponents(int N, int[][] graph) {
        visited = new boolean[N];
        for (int src = 0; src < N; src++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            int src = graph[i][0];
            int dst = graph[i][1];
            edges.get(src).add(dst);
            edges.get(dst).add(src);
        }

        int count = 0;
        for (int src = 0; src < N; src++) {
            if (!visited[src]) {
                dfs(src);
                count++;
            }
        }
        return count;
    }

    public void dfs(int src) {
        visited[src] = true;
        for (int dst : edges.get(src)) {
            if (!visited[dst]) {
                dfs(dst);
            }
        }
    }
}
