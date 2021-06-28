package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 20:46
 * @Description:
 */
public class _0513_findBottomLeftValue {

    int maxDepth = -1;
    int res = 0;

    public int findBottomLeftValue(TreeNode root) {
        recur(root, 1);
        return res;
    }

    public void recur(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            res = root.val;
            maxDepth = depth;
        }
        recur(root.left, depth + 1);
        recur(root.right, depth + 1);
    }
}
