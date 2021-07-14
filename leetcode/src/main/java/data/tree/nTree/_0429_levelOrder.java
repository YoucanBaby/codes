package data.tree.nTree;


import data.tree.TreeNode;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 22:09
 * @Description:
 */
public class _0429_levelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Node node = deque.removeFirst();
                if (node != null) {
                    level.add(node.val);
                }

                deque.addAll(node.children);

            }
            res.add(level);
        }
        return res;
    }
}
