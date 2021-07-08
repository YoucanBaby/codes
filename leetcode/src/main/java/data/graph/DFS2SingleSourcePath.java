package data.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 22:36
 * @Description: 通过DFS找单源路径
 */
public class DFS2SingleSourcePath {

    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    int[] path;

    public int[] solution(int n, int[][] relation) {
        visited = new int[n];
        path = new int[n];
        Arrays.fill(path, -1);

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
        // 假设节点0是DFS的起点
        for (int src = 0; src < n; src++) {
            if (visited[src] == 0) {
                dfs(src);
            }
        }
        return path;
    }

    public void dfs(int src) {
        visited[src] = 1;
        System.out.println(src);
        for (int dst : edges.get(src)) {
            if (visited[dst] == 0) {
                path[dst] = src;
                dfs(dst);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {
                {0,2},
                {2,1},
                {3,4},
                {2,3},
                {1,4},
                {2,0},
                {0,4}
        };

        DFS2SingleSourcePath solution = new DFS2SingleSourcePath();
        int[] path = solution.solution(n, relation);

        System.out.println(Arrays.toString(path));
    }
}
