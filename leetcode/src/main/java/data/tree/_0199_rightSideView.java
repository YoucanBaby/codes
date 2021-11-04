package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 21:13
 * @Description:
 */
public class _0199_rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int N = deque.size();
            TreeNode node = null;
            
            for (int i = 0; i < N; i++) {
                node = deque.removeFirst();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(node.val);
        }

        return res;
    }

    class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            List<Integer> res = new ArrayList<>();

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    if (i == size - 1) res.add(node.val);
                }
            }
            return res;
        }
    }
}
