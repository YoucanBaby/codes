package algorithm;

import sun.reflect.generics.tree.Tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 15:21
 * @Description:
 */
public class _17_12_convertBiNode {


    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = convertBiNode(root.left);
        if (left != null) {
            TreeNode temp = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root;
            left = temp;
        } else {
            left = root;
        }
        root.left = null;
        root.right = convertBiNode(root.right);

        return left;
    }
}
