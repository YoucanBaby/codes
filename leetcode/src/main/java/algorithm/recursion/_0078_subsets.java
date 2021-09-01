package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 16:13
 * @Description:
 */
public class _0078_subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _0078_subsets solution = new _0078_subsets();

        System.out.println(solution.subsets(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0);
            return res;
        }

        public void dfs(int[] nums, int start) {
            res.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
