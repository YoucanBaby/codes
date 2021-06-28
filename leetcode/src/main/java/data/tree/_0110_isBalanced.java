package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 18:37
 * @Description:
 */
public class _0110_isBalanced {

    public boolean isBalanced(TreeNode root) {
        return recur(root) == -1 ? false : true;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = recur(root.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = recur(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return -1;
        }
    }
}
