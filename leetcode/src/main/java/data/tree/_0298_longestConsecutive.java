package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 02:52
 * @Description:
 */
public class _0298_longestConsecutive {

    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return max;
    }

    private void dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return;
        }

        if (parent == null || root.val != parent.val + 1) {
            length = 1;
        } else {
            length++;
        }
        max = Math.max(max, length);

        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }
}
