package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 03:19
 * @Description:
 */
public class _0098_isValidBST {

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (pre != null && pre.val > root.val) {
            return false;
        }
        pre = root;

        return isValidBST(root.right);
    }
}
