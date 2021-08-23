package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 22:16
 * @Description:
 */
public class _0099_recoverTree {

    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {       // x和y都不为空，说明出现了错误节点，交换它们
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {           // x在前，y在后
                y = root;
                if (x == null) {
                    x = pre;
                }
            }
            pre = root;
        }
        dfs(root.right);
    }
}
