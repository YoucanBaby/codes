package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 16:05
 * @Description:
 */
public class _0951_flipEquiv {



    public boolean flipEquiv(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }

        return flipEquiv(A.left, B.left) && flipEquiv(A.right, B.right) ||
                flipEquiv(A.left, B.right) && flipEquiv(A.right, B.left);
    }
}
