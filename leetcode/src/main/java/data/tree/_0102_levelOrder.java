package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 15:24
 * @Description:
 */
public class _0102_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                TreeNode cur = deque.removeLast();
                level.add(cur.val);
                if (cur.left != null) {
                    deque.addFirst(cur.left);
                }
                if (cur.right != null) {
                    deque.addFirst(cur.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
