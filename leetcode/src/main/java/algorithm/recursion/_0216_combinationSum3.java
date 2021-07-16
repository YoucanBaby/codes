package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 19:18
 * @Description:
 */
public class _0216_combinationSum3 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, 0);
        return res;
    }

    public void dfs(int k, int n, int start, int sum) {
        if (sum > n) {
            return;
        }

        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum += i;
            dfs(k, n, i + 1, sum);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
