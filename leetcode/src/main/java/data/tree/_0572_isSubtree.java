package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 14:12
 * @Description:
 */
public class _0572_isSubtree {

    public boolean isSubtree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        return isSameTree(A, B) || isSubtree(A.left, B) || isSubtree(A.right, B);
    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        return A.val == B.val && isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
    }

}

