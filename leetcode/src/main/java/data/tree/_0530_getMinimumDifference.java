package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 03:52
 * @Description:
 */
public class _0530_getMinimumDifference {

    int res = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMinimumDifference(root.left);
        if (pre != null) {
            res = Math.min(res, Math.abs(pre.val - root.val));
        }
        pre = root;
        getMinimumDifference(root.right);

        return res;
    }

    // 练习
    class Solution {

        int res = Integer.MAX_VALUE;
        TreeNode pre = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return 0;
            }

            getMinimumDifference(root.left);
            if (pre != null) {
                res = Math.min(res, Math.abs(pre.val - root.val));
            }
            pre = root;
            getMinimumDifference(root.right);

            return res;
        }
    }
}
