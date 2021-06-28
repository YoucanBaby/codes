package data.tree;


/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-26 12:09
 * @Description:
 */
public class _0055_maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归左子树
        int leftDepth = maxDepth(root.left);
        // 递归右子树
        int rightDepth = maxDepth(root.right);
        // 返回值
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
