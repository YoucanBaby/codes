package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 10:52
 * @Description:
 */
public class isValidCBT {

    public boolean isValidCBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        // 判断是否遇到一个节点左右子树不全，即后序的节点都要是叶结点
        boolean isLeft = false;

        while (!deque.isEmpty()) {
            root= deque.removeLast();
            TreeNode left = root.left;
            TreeNode right = root.right;

            // 任意节点，有右无左false。
            if (left != null && right == null) {
                return false;
            }
            // 如果遇到了一个节点左右子树不全，需要保证后序节点都是叶结点。
            if (isLeft) {
                if (left == null || right == null) {
                    return false;
                }
            }

            if (left != null) {
                deque.addFirst(left);
            }
            if (right != null) {
                deque.addFirst(right);
            }

            // 如果遇到了一个节点左右子树不全，需要保证后序节点都是叶结点。
            if (left == null || right == null) {
                isLeft = true;
            }
        }
        return true;
    }
}
