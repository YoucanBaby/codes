package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 16:42
 * @Description:
 */
public class _0958_isCompleteTree {

    public static void main(String[] args) {
        _0958_isCompleteTree solution = new _0958_isCompleteTree();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(solution.isCompleteTree(root));
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        boolean flag = false;       // 是否遇到了null
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node != null) {
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                    if (flag) {
                        return false;
                    }
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }

    class Solution {

        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return false;
            }

            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            boolean flag = false;

            while (!deque.isEmpty()) {
                int size = deque.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    if (node != null) {
                        deque.addLast(node.left);
                        deque.addLast(node.right);
                        if (flag) return false;
                    } else {
                        flag = true;
                    }
                }
            }
            return true;
        }
    }
}
