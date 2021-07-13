package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 05:19
 * @Description:
 */
public class _0116_connect {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Node> level = new ArrayList<>();

            int N = deque.size();
            for (int i = 0; i < N; i++) {
                Node cur = deque.removeFirst();
                level.add(cur);

                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }

            int M = level.size();
            for (int i = 0; i < M - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
        }

        return root;
    }

    // 递归
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}


