package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 09:50
 * @Description:
 */
public class _0337_rob {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int dp0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int dp1 = root.val + left[0] + right[0];
        return new int[] {dp0, dp1};
    }


    class Solution {

        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        public int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[] {0, 0};
            }

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            int dp0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            int dp1 = left[0] + root.val + right[0];
            return new int[] {dp0, dp1};
        }
    }
}
