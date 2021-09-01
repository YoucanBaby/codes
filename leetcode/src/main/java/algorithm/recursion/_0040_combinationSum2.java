package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 22:50
 * @Description:
 */
public class _0040_combinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;

        _0040_combinationSum2 solution = new _0040_combinationSum2();
        System.out.println(solution.combinationSum2(candidates, target));
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
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
            if (sum + nums[i] > target) {     // 剪枝
                break;
            }
            if (i - 1 >= start && nums[i] == nums[i - 1]) {  // 去重
                continue;
            }

            path.add(nums[i]);
            dfs(nums, target, sum + nums[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
