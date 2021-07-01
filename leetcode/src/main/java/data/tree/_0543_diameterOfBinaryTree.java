package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 21:00
 * @Description:
 */
public class _0543_diameterOfBinaryTree {

    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (leftDepth + rightDepth > max) {
            max = leftDepth + rightDepth;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }


}
