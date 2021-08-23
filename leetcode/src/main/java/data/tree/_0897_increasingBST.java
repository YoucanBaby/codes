package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 02:44
 * @Description:
 */
public class _0897_increasingBST {


    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        TreeNode newNode = new TreeNode(-1);
        TreeNode cur = newNode;
        for (int value : list) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }
        return newNode.right;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
