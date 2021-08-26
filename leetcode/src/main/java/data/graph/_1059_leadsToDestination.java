package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 22:32
 * @Description:
 */
public class _1059_leadsToDestination {

    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;

    public boolean leadsToDestination(int N, int[][] relations, int src, int target) {
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            edges.get(r[0]).add(r[1]);
        }

        if (edges.get(target).size() != 0) {
            return false;
        }
        visited[src] = true;
        return dfs(src, target);
    }

    private boolean dfs(int src, int target) {
        if (edges.get(src).size() == 0) {
            return src == target;
        }
        for (int dst : edges.get(src)) {
            if (visited[dst]) {
                return false;
            }
            visited[dst] = true;
            if (!dfs(dst, target)) {
                return false;
            }
            visited[dst] = false;
        }
        return true;
    }
}
