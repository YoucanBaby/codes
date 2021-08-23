package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 03:19
 * @Description:
 */
public class _0098_isValidBST {


    class Solution {
        TreeNode pre;           // 上一次处理的节点

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            boolean left = isValidBST(root.left);
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            boolean right = isValidBST(root.right);

            return left && right;
        }
    }
}
