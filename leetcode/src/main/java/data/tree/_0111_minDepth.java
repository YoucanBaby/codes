package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 17:43
 * @Description:
 */
public class _0111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 左孩子和右孩子都为空，返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 当root节点左右孩子有一个为空时，返回不为空的孩子节点的深度
        if (root.left == null) {
            return rightDepth + 1;
        }
        else if (root.right == null) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }


}
