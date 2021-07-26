package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 15:59
 * @Description:
 */
public class _0509_fib {

    // 递归
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 动态规划 + 滚动数组
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }

        return cur;
    }


}
