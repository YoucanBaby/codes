package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 01:11
 * @Description:
 */
public class _0230_kthSmallest {

    class Solution {
        TreeNode res;
        int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res.val;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);
            k--;
            if (k == 0) {
                res = root;
                return;
            }
            dfs(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }
}
