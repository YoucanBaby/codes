package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 00:19
 * @Description:
 */
public class _0671_findSecondMinimumValue {

    int min1 = Integer.MAX_VALUE;   // 最小值
    int min2 = Integer.MAX_VALUE;   // 倒数第二小的值
    boolean flag;                   // 倒数第二小的值是否更新

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return flag == true ? min2 : -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val < min1) {
            min2 = min1;
            min1 = root.val;
        }
        if (min1 < root.val && root.val <= min2) {
            min2 = root.val;
            flag = true;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
