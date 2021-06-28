package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 17:33
 * @Description:
 */
public class _0101_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null) {
            return false;
        }
        if (L.val != R.val) {
            return false;
        }

        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
