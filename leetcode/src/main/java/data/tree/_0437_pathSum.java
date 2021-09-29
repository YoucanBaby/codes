package data.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 13:43
 * @Description:
 */
public class _0437_pathSum {

    int res = 0;
    Map<Integer, Integer> freq =  new HashMap<>();       // <前缀和，前缀和出现的次数>

    public int pathSum(TreeNode root, int target) {
        freq.put(0, 1);
        dfs(root, target, 0);
        return res;
    }

    private void dfs(TreeNode root, int target, int sum) {
        if (root == null) return;

        sum += root.val;
        res += freq.getOrDefault(sum - target, 0);
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);

        dfs(root.left, target, sum);
        dfs(root.right, target, sum);
        freq.put(sum, freq.getOrDefault(sum, 0) - 1);
    }
}
