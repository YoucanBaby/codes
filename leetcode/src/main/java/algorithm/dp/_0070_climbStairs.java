package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 16:22
 * @Description:
 */
public class _0070_climbStairs {


    // 动态规划优化，滚动数组
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int p = 1;
        int q = 2;
        for (int i = 3; i <= n; i++) {
            int temp = p + q;
            p = q;
            q = temp;
        }

        return q;
    }

    // 动态规划
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 记忆化递归
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[1] = 1;
        } else if (n == 2) {
            memo[2] = 2;
        } else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }

        return memo[n];
    }
}
