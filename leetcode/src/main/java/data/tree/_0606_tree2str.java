package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 22:42
 * @Description:
 */
public class _0606_tree2str {


    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        if (root.left == null && root.right == null) {
            return "" + root.val;
        } else if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        } else {
            return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        }
    }
}
