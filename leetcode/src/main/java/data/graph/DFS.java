package data.graph;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 17:04
 * @Description:
 */
public class DFS {

    public void dfs2(Node node) {
        if (node == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();

        stack.addFirst(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node cur = stack.removeFirst();
            for (Node next: cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
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

        DFS solution = new DFS();
        solution.solution(n, relation);
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
        // 遍历所有没有被访问过的源点，对其做DFS
        for (int src = 0; src < n; src++) {
            if (!visited[src]) {
                dfs(src);
            }
        }
    }

    // 深度优先先序遍历
    public void dfs(int src) {
        visited[src] = true;
        System.out.println(src);
        for (int dst : edges.get(src)) {
            if (!visited[dst]) {
                dfs(dst);
            }
        }
    }

    // 深度优先后序遍历
    public void dfs1(int src) {
        visited[src] = true;
        for (int dst : edges.get(src)) {
            if (!visited[dst]) {
                dfs1(dst);
            }
        }
        System.out.println(src);
    }
}
