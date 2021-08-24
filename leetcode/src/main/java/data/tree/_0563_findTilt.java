package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 14:11
 * @Description:
 */
public class _0563_findTilt {

    int res = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        res += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
