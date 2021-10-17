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
            stackAddLeft(root);
        }

        private void stackAddLeft(TreeNode root) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode root = stack.removeLast();
            stackAddLeft(root.right);
            return root.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
