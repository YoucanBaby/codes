package data.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 17:04
 * @Description:
 */
public class DFS {

    public void dfs(Node node) {
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
}
