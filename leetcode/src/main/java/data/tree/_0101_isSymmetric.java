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
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null) {
            return false;
        }

        if (L.val != R.val) {
            return false;
        }
        return dfs(L.left, R.right) && dfs(L.right, R.left);
    }



    class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }

            return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }
}
