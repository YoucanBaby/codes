package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 06:31
 * @Description:
 */
public class _0047_permuteUnique {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int N = nums.length;
        boolean[] used = new boolean[N];
        Arrays.sort(nums);

        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == true) {
                continue;
            }
            if (used[i] == false) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
