package data.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 22:17
 * @Description:
 */
public class _0655_printTree {


    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        String[][] res = new String[depth][(1 << depth) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        dfs(res, root, 0, 0, res[0].length - 1);

        List<List<String>> list = new ArrayList<>();
        for (String[] arr : res) {
            list.add(Arrays.asList(arr));
        }
        return list;
    }

    private void dfs(String[][] res, TreeNode root, int depth, int left, int right) {
        if (root == null) {
            return;
        }

        int mid = (left + right) / 2;
        res[depth][mid] = String.valueOf(root.val);

        dfs(res, root.left, depth + 1, left, mid - 1);
        dfs(res, root.right, depth + 1, mid + 1, right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = getDepth(root.left);
        int rightMaxDepth = getDepth(root.right);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
