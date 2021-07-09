package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 01:54
 * @Description:
 */
public class BFS2SingleSourcePath {

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
        BFS2SingleSourcePath bfs = new BFS2SingleSourcePath();

        int[] res = bfs.solution(n, relation);
        System.out.println(Arrays.toString(res));
    }

    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;
    int[] path;

    // n是节点个数，relation由题目给出，relation[i][0]➡ relation[i][1]
    public int[] solution(int n, int[][] relation) {
        visited = new boolean[n];
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
        // BFS，遍历是为了避免有多个连通分量
        for (int src = 0; src < n; src++) {
            if (!visited[src]) {
                bfs(src);
            }
        }

        return path;
    }

    // 广度优先遍历
    public void bfs(int src) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(src);
        visited[src] = true;

        while (!deque.isEmpty()) {
            src = deque.removeFirst();
            System.out.println(src);

            for (int dst : edges.get(src)) {
                if (!visited[dst]) {
                    deque.addLast(dst);
                    visited[dst] = true;
                    path[dst] = src;
                }
            }
        }
    }
}
