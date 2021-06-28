package data.tree;



/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 10:14
 * @Description:
 */
public class _04_05_isValidBST {

    public static void main(String[] args) {

    }

    // 上一次处理的节点
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return  true;
        }
        // 左子树是否是二叉搜索树
        boolean L = isValidBST(root.left);

        // 判断是否是二叉搜索树
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        // 更新pre
        pre = root;

        // 右子树是否是二叉搜索树
        boolean R = isValidBST(root.right);

        return L && R;
    }
}
