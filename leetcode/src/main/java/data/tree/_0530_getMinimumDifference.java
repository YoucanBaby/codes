package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 03:52
 * @Description:
 */
public class _0530_getMinimumDifference {

    public static void main(String[] args) {

    }

    int res = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归左子树
        getMinimumDifference(root.left);
        // 如果root还在初始位置，即pre未初始化，就跳过这一步，把root赋给root
        if (pre != null) {
            res = Math.min(res, Math.abs(pre.val - root.val));
        }
        pre = root;
        // 递归右子树
        getMinimumDifference(root.right);

        return res;
    }
}
