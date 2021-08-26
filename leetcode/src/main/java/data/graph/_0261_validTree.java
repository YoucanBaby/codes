package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 02:34
 * @Description:
 */
public class _0261_validTree {


    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;

    public boolean validTree(int N, int[][] graph) {
        if (N - 1 != graph.length) {
            return false;
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] g : graph) {
            edges.get(g[0]).add(g[1]);
            edges.get(g[1]).add(g[0]);
        }

        dfs(0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int src) {
        visited[src] = true;
        for (int dst : edges.get(src)) {
            if (!visited[dst]) {
                dfs(dst);
            }
        }
    }
}
