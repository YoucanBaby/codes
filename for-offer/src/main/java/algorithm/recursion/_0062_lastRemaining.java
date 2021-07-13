package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 17:18
 * @Description:
 */
public class _0062_lastRemaining {

    public static void main(String[] args) {
        _0062_lastRemaining solution = new _0062_lastRemaining();

        System.out.println(solution.lastRemaining1(5, 3));
        System.out.println(solution.lastRemaining(5, 3));
    }

    // 迭代
    public int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;  // 下标
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    // 递归
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (x + m) % n;
    }

    // 动态规划
    public int lastRemaining2(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = (dp + m) % i;
        }
        return dp;
    }
}
