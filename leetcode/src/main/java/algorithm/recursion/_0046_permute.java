package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 04:49
 * @Description:
 */
public class _0046_permute {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int N = nums.length;
        boolean[] used = new boolean[N];

        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
