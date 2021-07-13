package data.graph.base;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 16:32
 * @Description:
 */
public class BFS {

    public void bfs2(Node node) {
        if (node == null) {
            return;
        }
        Deque<Node> deque = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();

        deque.addFirst(node);
        set.add(node);

        while (!deque.isEmpty()) {
            Node cur = deque.removeLast();
            System.out.println(cur.value);
            for (Node next: cur.nexts) {
                if (!set.contains(cur)) {
                    deque.addFirst(cur);
                    set.add(cur);
                }
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
        BFS bfs = new BFS();

        bfs.solution(n, relation);
    }


    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;

    // n是节点个数，relation由题目给出，relation[i][0]➡ relation[i][1]
    public void solution(int n, int[][] relation) {
        visited = new boolean[n];
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
                }
            }
        }
    }

}
