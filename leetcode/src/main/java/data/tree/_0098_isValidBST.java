package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 03:19
 * @Description:
 */
public class _0098_isValidBST {

    public static void main(String[] args) {

    }

    // 上一次处理的节点
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean L = isValidBST(root.left);

        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        boolean R = isValidBST(root.right);

        return L && R;
    }
}
