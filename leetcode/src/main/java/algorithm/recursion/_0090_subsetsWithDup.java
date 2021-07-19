package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 04:05
 * @Description:
 */
public class _0090_subsetsWithDup {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);          // 一定要排序
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
