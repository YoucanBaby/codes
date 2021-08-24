package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 14:35
 * @Description:
 */
public class _0156_upsideDownBinaryTree {


    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {                                 // 空，返回
            return null;
        }
        if (root.left == null && root.right == null) {      // 叶子节点，返回
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left); // 左儿子是新的节点

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
