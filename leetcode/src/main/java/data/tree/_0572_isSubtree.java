package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 14:12
 * @Description:
 */
public class _0572_isSubtree {

}

class Solution {
    public boolean isSubtree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return isSubtreeWithRoot(A, B)
                || isSubtree(A.left, B) || isSubtree(A.right, B);
    }

    public boolean isSubtreeWithRoot(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            return isSubtreeWithRoot(A.left, B.left)
                    && isSubtreeWithRoot(A.right, B.right);
        } else {
            return false;
        }
    }
}