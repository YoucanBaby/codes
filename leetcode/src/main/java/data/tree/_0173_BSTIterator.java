package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 17:16
 * @Description:
 */
public class _0173_BSTIterator {


    class BSTIterator {

        Deque<TreeNode> stack = new ArrayDeque<>();         // 右边是栈顶

        public BSTIterator(TreeNode root) {
            dfsLeft(root);
        }

        private void dfsLeft(TreeNode root) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode root = stack.removeLast();
            int res = root.val;
            dfsLeft(root.right);
            return res;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
