package data.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-04 16:32
 * @Description:
 */
public class BFS {

    public void bfs(Node node) {
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
}
