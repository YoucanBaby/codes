package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 17:04
 * @Description:
 */
public class _0077_combine {


    List<List<Integer>> res = new ArrayList<>();    // 二维数组res
    List<Integer> path = new ArrayList<>();         // 一维数组path

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return new ArrayList<>();
        }

        dfs(n, k, 1)   ;
        return res;
    }

    public void dfs(int n, int k, int start) {
        // 剪枝：path长度加上区间长度[start, n] 的长度小于k，就不可能构造出长度为k的path
        if (path.size() + (n - start + 1) < k) {
            return;
        }

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1);
            return res;
        }

        private void dfs(int n, int k, int start) {
            // 剪枝：path长度加上区间长度[start, n] 的长度小于k，就不可能构造出长度为k的path
            if (path.size() + (n - start + 1) < k) {
                return;
            }
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i <= n; i++) {
                path.add(i);
                dfs(n, k, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
