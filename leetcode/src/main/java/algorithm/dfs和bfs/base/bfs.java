package algorithm.dfs和bfs.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs.base
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 05:32
 * @Description:
 */
public class bfs {

    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node[] getNext() {
            return new Node[] {this.next};
        }
    }

    public int bfs(Node start, Node target) {
        Deque<Node> deque = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        deque.addLast(start);
        visited.add(start);

        int step = 0;
        while (!deque.isEmpty()) {
            step++;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node cur = deque.removeFirst();
                if (cur == target) {
                    return step;
                }

                for (Node next : cur.getNext()) {
                    if (!visited.contains(next)) {
                        deque.addLast(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
