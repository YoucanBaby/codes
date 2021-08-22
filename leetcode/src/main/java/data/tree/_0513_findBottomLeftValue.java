package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 20:46
 * @Description:
 */
public class _0513_findBottomLeftValue {

    int res = 0;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            res = root.val;
            maxDepth = depth;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
