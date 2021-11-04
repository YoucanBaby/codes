package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 21:00
 * @Description:
 */
public class _0543_diameterOfBinaryTree {

    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    class Solution {

        int max = -1;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max, leftDepth + rightDepth);

            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
