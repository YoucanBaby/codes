package data.tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 19:27
 * @Description:
 */
public class _0103_zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean flag = true;        // flag为true从左向右，flag为false从右向左

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (flag) level.add(node.val);
                else level.add(0, node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
