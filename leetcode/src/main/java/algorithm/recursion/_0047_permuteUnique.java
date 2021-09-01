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
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int N = nums.length;
        used = new boolean[N];
        Arrays.sort(nums);

        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && used[i - 1] == true) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
