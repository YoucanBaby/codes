package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-29 13:54
 * @Description:
 */
public class _0113_pathSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, sum, paths, new ArrayList<Integer>());
        return paths;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                paths.add(path);
            }
        } else {
            dfs(root.left, sum - root.val, paths, path);
            dfs(root.right, sum - root.val, paths, path);
        }
    }
}
