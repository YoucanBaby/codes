package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 21:21
 * @Description:
 */
public class _0515_largestValues {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                max = Math.max(max, node.val);
            }
            res.add(max);
        }

        return res;
    }
}
