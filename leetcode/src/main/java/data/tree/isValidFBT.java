package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 14:33
 * @Description:
 */
public class isValidFBT {
    // 二叉树节点个数
    int num = 0;

    public boolean isValidFBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        int depth = maxDepth(root);
        countNum(root);

        return depth == (1 << num - 1);
    }

    public void countNum(TreeNode root) {
        if (root == null) {
            return;
        }

        countNum(root.left);
        countNum(root.right);
        num++;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
