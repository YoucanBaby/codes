package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 22:07
 * @Description:
 */
public class _0039_combinationSum {


    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] nums, int target) {
            Arrays.sort(nums);
            dfs(nums, target, 0, 0);
            return res;
        }

        public void dfs(int[] nums, int target, int sum, int start) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (sum + nums[i] > target) {
                    return;
                }

                path.add(nums[i]);
                dfs(nums, target, sum + nums[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}
