package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 21:37
 * @Description: 通过DFS找具体的连通图
 */
public class DFS2CC {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;

    public void solution(int n, int[][] relation) {
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
        int id = 1;
        for (int src = 0; src < n; src++) {
            if (visited[src] == 0) {
                dfs(src, id);
                id++;
            }
        }
    }

    // 深度优先先序遍历
    public void dfs(int src, int id) {
        visited[src] = id;
        System.out.println(src);
        for (int dst : edges.get(src)) {
            if (visited[dst] == 0) {
                dfs(dst, id);
            }
        }
    }
}
