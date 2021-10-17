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

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }
}
