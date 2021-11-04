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


    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<Integer> path = new ArrayList<>();
            dfs(root, target);
            return res;
        }

        public void dfs(TreeNode root, int target) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null && root.val == target) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }

            path.add(root.val);
            dfs(root.left, target - root.val);
            dfs(root.right, target - root.val);
            path.remove(path.size() - 1);
        }
    }
}
