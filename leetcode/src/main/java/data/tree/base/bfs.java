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
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            TreeNode cur = deque.removeLast();
            list.add(cur.val);
            if (cur.left != null) {
                deque.addFirst(cur.left);
            }
            if (cur.right != null) {
                deque.addFirst(cur.right);
            }
        }

        return list;
    }
}
