package algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 03:55
 * @Description:
 */
public class _0060_getPermutation {

    public static void main(String[] args) {
        _0060_getPermutation solution = new _0060_getPermutation();

        System.out.println(solution.getPermutation(3, 3));
    }

    int count = 0;
    StringBuilder path = new StringBuilder();

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[n];

        return dfs(nums, used, k);
    }

    public String dfs(int[] nums, boolean[] used, int k) {
        if (path.length() == nums.length) {
            count++;
            if (count == k) {
                return path.toString();
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.append(nums[i]);
            used[i] = true;
            if (!dfs(nums, used, k).equals("")) {
                return path.toString();
            }
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
        return "";
    }


    class Solution {
        int n;
        int k;
        boolean[] used;
        int[] factorial;
        StringBuilder path = new StringBuilder();

        public String getPermutation(int n, int k) {
            this.n = n;
            this.k = k;
            used = new boolean[n + 1];
            factorial = getFactorial(n);           // 阶乘

            dfs(0);
            return path.toString();
        }

        private void dfs(int depth) {
            if (depth == n) {
                return;
            }

            int count = factorial[n - 1 - depth];
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                if (k > count) {
                    k -= count;
                    continue;
                }

                path.append(i);
                used[i] = true;
                dfs(depth + 1);
                return;
            }
        }

        private int[] getFactorial(int n) {
            int[] factorial = new int[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            return factorial;
        }
    }
}
