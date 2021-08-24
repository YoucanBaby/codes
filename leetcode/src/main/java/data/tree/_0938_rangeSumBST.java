package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 12:48
 * @Description:
 */
public class _0938_rangeSumBST {

    int res = 0;

    public int rangeSumBST(TreeNode root, int left, int right) {
        dfs(root, left, right);
        return res;
    }

    private void dfs(TreeNode root, int left, int right) {
        if (root == null) {
            return;
        }

        dfs(root.left, left, right);
        if (left <= root.val && root.val <= right) {
            res += root.val;
        }
        dfs(root.right, left, right);
    }
}
