package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 18:37
 * @Description:
 */
public class _0110_isBalanced {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }


}
