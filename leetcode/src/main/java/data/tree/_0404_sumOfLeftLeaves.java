package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-28 20:18
 * @Description:
 */
public class _0404_sumOfLeftLeaves {

    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }

        int value = 0;
        if (flag == true && root.left == null && root.right == null) {
            value = root.val;
        }

        int leftValue = dfs(root.left, true);
        int rightValue = dfs(root.right, false);

        return value + leftValue + rightValue;
    }
}
