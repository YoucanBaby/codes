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

    // 只有做为根节点，才能选左右子节点；不然的话，作为路径上的一份子，只能选择左边或者右边
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxSum = Math.max(0, dfs(root.left));           // 不选左边为0，选左边有值
        int rightMaxSum = Math.max(0, dfs(root.right));         // 不选右边为0，选右边有值

        max = Math.max(max, root.val + leftMaxSum + rightMaxSum);       // 全局最大和

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }



    class Solution {

        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMaxPath(root);
            return max;
        }

        public int getMaxPath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftMaxSum = Math.max(0, getMaxPath(root.left));
            int rightMaxSum = Math.max(0, getMaxPath(root.right));

            max = Math.max(max, leftMaxSum + root.val + rightMaxSum);

            return root.val + Math.max(leftMaxSum, rightMaxSum);
        }
    }
}
