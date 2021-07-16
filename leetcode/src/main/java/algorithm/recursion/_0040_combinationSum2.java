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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            // 树层去重，去重之前集合要排序
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int num = candidates[i];
            sum += num;
            path.add(num);
            dfs(candidates, target, sum, i + 1);   // 递归
            sum -= num;         // 回溯
            path.remove(path.size() - 1);   // 回溯
        }
    }
}
