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

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                root = deque.removeLast();
                level.add(root.val);
                if (root.left != null) {
                    deque.addFirst(root.left);
                }
                if (root.right != null) {
                    deque.addFirst(root.right);
                }
            }
            list.add(0, level);
        }

        return list;
    }
}
