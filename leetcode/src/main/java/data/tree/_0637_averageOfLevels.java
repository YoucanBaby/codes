package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 21:24
 * @Description:
 */
public class _0637_averageOfLevels {


    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            double sum = 0;

            for (int i = 0; i < N; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                sum += node.val;
            }
            res.add(sum / N);
        }

        return res;
    }
}
