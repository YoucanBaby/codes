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

    // 递归
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNodes(root.left, root.right);
        return root;
    }

    private void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);

        connectTwoNodes(node1.right, node2.left);
    }
}


