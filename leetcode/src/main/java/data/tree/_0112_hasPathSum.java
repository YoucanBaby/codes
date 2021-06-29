package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-29 11:59
 * @Description:
 */
public class _0112_hasPathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 如果当前节点是叶子节点
        if (root.left == null && root.right ==null) {
            return root.val == sum;
        } else {
            boolean left = hasPathSum(root.left, sum - root.val);
            boolean right = hasPathSum(root.right, sum - root.val);
            return left || right;
        }
    }




}
