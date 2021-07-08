package data.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 22:09
 * @Description:
 */
public class _0547_findCircleNum {

    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;

    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        visited = new int[N];
        // 初始化边
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加所有的边
        for (int src = 0; src < N; src++) {
            for (int dst = 0; dst < N; dst++) {
                if (isConnected[src][dst] == 1) {
                    edges.get(src).add(dst);
                }
            }
        }
        // DFS
        int count = 0;
        for (int src = 0; src < N; src++) {
            if (visited[src] == 0) {
                dfs(src);
                count++;
            }
        }
        return count;
    }

    public void dfs(int src) {
        visited[src] = 1;
        for (int dst : edges.get(src)) {
            if (visited[dst] == 0) {
                dfs(dst);
            }
        }
    }
}
