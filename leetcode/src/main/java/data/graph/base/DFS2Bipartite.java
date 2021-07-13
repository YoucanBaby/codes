package data.graph.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 19:55
 * @Description:
 */
public class DFS2Bipartite {

    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;      // 0,没有访问过,不染色; -1,染绿色; 1,染蓝色

    public boolean isBipartite(int n, int[][] relation) {
        visited = new int[n];
        // 初始化边
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加所有的边
        for (int[] edge : relation) {
            int src = edge[0];
            int dst = edge[1];
            edges.get(src).add(dst);
        }
        // DFS
        for (int src = 0; src < n; src++) {
            // 如果没有访问过该源点，就做DFS，DFS返回false，我们就返回false
            if (visited[src] == 0) {
                if (!dfs(src, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int src, int color) {
        visited[src] = color;

        for (int dst : edges.get(src)) {
            // DFS
            if (visited[dst] == 0) {
                if (!dfs(dst, -color)) {
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
}
