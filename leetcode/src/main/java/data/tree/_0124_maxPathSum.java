package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-22 15:31
 * @Description:
 */
public class _0124_maxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // 只有在当前节点是root的时候才能够同时选左边和右边；不然的话，作为路径上的一份子，只能选择左边或者右边
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxSum = Math.max(0, dfs(root.left));
        int rightMaxSum = Math.max(0, dfs(root.right));

        max = Math.max(max, root.val + leftMaxSum + rightMaxSum);       // 全局最大和

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
