package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 17:43
 * @Description:
 */
public class _0111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return Math.max(leftMinDepth, rightMinDepth) + 1;
        } else {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }
    }
}
