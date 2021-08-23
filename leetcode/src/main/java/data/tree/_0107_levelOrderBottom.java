package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-29 22:47
 * @Description:
 */
public class _0107_levelOrderBottom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                root = deque.removeFirst();
                level.add(root.val);
                if (root.left != null) {
                    deque.addLast(root.left);
                }
                if (root.right != null) {
                    deque.addLast(root.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }
}
