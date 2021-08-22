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

    Map<Integer, Integer> preSumCount =  new HashMap<Integer, Integer>();   // <前缀和，前缀和出现的次数>

    public int pathSum(TreeNode root, int target) {
        preSumCount.put(0, 1);
        return dfs(root, target, 0);
    }

    // 根节点root，目标值target，当前路径上的和sum
    private int dfs(TreeNode root, int target, int sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        sum += root.val;
        res += preSumCount.getOrDefault(sum - target, 0);
        preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) + 1);

        res += dfs(root.left, target, sum);
        res += dfs(root.right, target, sum);

        preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) - 1);
        return res;
    }
}
