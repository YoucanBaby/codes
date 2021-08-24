package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 15:14
 * @Description:
 */
public class _0814_pruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right= pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }

        return root;
    }
}
