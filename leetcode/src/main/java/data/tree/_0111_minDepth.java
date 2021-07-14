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
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int depth = 0;
        if (root.left == null) {
            depth = rightDepth + 1;
        }
        else if (root.right == null) {
            depth = leftDepth + 1;
        } else {
            depth = Math.min(leftDepth, rightDepth) + 1;
        }

        return depth;
    }


}
