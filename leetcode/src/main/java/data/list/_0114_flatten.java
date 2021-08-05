package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 11:16
 * @Description:
 */
public class _0114_flatten {


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
