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

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(target - root.val);
        }

        boolean left = findTarget(root.left, target);
        boolean right = findTarget(root.right, target);

        return left || right;
    }
}
