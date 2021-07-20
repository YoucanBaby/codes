package algorithm.recursion;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 08:37
 * @Description:
 */
public class _0491_findSubsequences {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
            // 这里不能加return，因为还需要树上的节点
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
