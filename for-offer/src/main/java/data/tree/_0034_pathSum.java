package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-01 17:36
 * @Description:
 */
public class _0034_pathSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        if (root.val == target && root.left == null && root.right == null) {
            path.add(root.val);
            res.add(new ArrayList<>(path));
        }

        path.add(root.val);
        // 递归左节点，递归右节点，回溯
        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
        path.remove(path.size() - 1);
    }


}
