package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 17:43
 * @Description:
 */
public class _0111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
