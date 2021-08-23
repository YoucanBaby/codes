package data.tree;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 17:07
 * @Description:
 */
public class _0054_kthLargest {

    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }

}
