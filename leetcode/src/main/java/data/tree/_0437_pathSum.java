package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 13:43
 * @Description:
 */
public class _0437_pathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return recur(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int recur(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum -= root.val;
        int temp = 0;
        if (sum == 0) {
            temp = 1;
        }

        return temp + recur(root.left, sum) + recur(root.right, sum);
    }
}
