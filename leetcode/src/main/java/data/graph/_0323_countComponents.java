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
    List<List<Integer>> list = new ArrayList<>();
    int N;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        this.N = n;
        visited = new boolean[N];
        // 初始化所有的边
        for (int src = 0; src < N; src++) {
            list.add(new ArrayList<>());
        }
        // 添加所有的边
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            list.get(src).add(dst);
            list.get(dst).add(src);
        }
        // 遍历所有的节点做DFS
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
        for (int dst : list.get(src)) {
            if (!visited[dst]) {
                dfs(dst);
            }
        }
    }
}
