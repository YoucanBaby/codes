package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-25 23:16
 * @Description:
 */
public class _0797_allPathsSourceTarget {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        path.add(0);
        dfs(edges, 0, edges.length - 1);
        return res;
    }

    private void dfs(int[][] edges, int src, int target) {
        if (src == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int dst : edges[src]) {
            path.add(dst);
            dfs(edges, dst, target);
            path.remove(path.size() - 1);
        }
    }
}
