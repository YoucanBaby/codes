package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 20:18
 * @Description:
 */
public class _0404_sumOfLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return res;
    }


    class Solution {

        int res = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                }
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);

            return res;
        }
    }
}
