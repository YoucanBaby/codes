package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 15:18
 * @Description:
 */
public class _0129_sumNumbers {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res += sum * 10 + root.val;
        }
        dfs(root.left, sum * 10 + root.val);
        dfs(root.right, sum * 10 + root.val);
    }


    class Solution {

        int res = 0;

        public int sumNumbers(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        public void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }

            sum = sum * 10 + root.val;
            if (root.left == null && root.right == null) {
                res += sum;
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }
}
