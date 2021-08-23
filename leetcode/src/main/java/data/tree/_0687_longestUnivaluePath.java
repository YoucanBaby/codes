package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 01:59
 * @Description:
 */
public class _0687_longestUnivaluePath {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight = right + 1;
        }
        res = Math.max(res, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }
}
