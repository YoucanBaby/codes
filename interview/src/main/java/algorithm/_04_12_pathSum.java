package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-24 02:59
 * @Description:
 */
public class _04_12_pathSum {

    Map<Integer, Integer> preSumCount =  new HashMap<Integer, Integer>();   // <前缀和，前缀和出现的次数>
    int res = 0;

    public int pathSum(TreeNode root, int target) {
        preSumCount.put(0, 1);
        dfs(root, target, 0);
        return res;
    }

    // 根节点root，目标值target，当前路径上的和sum
    private void dfs(TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        res += preSumCount.getOrDefault(sum - target, 0);
        preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) + 1);

        dfs(root.left, target, sum);
        dfs(root.right, target, sum);
        preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) - 1);
    }
}
