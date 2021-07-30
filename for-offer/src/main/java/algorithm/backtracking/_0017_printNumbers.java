package algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.backtracking
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 15:47
 * @Description:
 */
public class _0017_printNumbers {

    public static void main(String[] args) {
        int n = 3;
        _0017_printNumbers solution = new _0017_printNumbers();
        int[] res = solution.printNumbers(n);

        System.out.println(Arrays.toString(res));
    }

    List<Integer> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;

    public int[] printNumbers(int n) {
        this.n = n;

        int N = (int) (Math.pow(10, n)  -1);
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        boolean[] used = new boolean[n];

        dfs(nums);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public void dfs(int[] nums) {
        if (path.size() == n) {
            String temp = String.valueOf(path);
            System.out.println(path);
            res.add(Integer.valueOf(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
        }
    }
}
