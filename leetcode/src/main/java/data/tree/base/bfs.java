package data.tree.base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-26 15:41
 * @Description:
 */
public class bfs {

    public List<Integer> bfs (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            res.add(node.val);
            if (node.left != null) {
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                deque.addFirst(node.right);
            }
        }

        return res;
    }
}
