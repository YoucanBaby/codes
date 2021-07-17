package data.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-18 02:21
 * @Description:
 */
public class _0653_findTarget {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        boolean res = dfs(root, k, set);
        return res;
    }

    public boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }


        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(k - root.val);
        }

        boolean left = dfs(root.left, k, set);
        boolean right = dfs(root.right, k, set);

        return left || right;
    }
}
