package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 18:37
 * @Description:
 */
public class _0110_isBalanced {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return -1;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) == -1 ? false : true;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = dfs(root.left);
            if (leftDepth == -1) {
                return -1;
            }
            int rightDepth = dfs(root.right);
            if (rightDepth == -1) {
                return -1;
            }

            if (Math.abs(leftDepth - rightDepth) <= 1) {
                return Math.max(leftDepth, rightDepth) + 1;
            } else {
                return -1;
            }
        }
    }
}
