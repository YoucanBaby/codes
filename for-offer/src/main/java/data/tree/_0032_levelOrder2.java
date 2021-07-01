package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 16:17
 * @Description:
 */
public class _0032_levelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                root = deque.removeLast();
                temp.add(root.val);

                if (root.left != null) {
                    deque.addFirst(root.left);
                }
                if (root.right != null) {
                    deque.addFirst(root.right);
                }
            }
            list.add(temp);
        }

        return list;
    }
}
