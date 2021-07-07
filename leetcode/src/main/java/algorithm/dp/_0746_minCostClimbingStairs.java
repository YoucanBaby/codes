package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 16:53
 * @Description:
 */
public class _0746_minCostClimbingStairs {

    public int minCostClimbingStairs1(int[] cost) {
        int N = cost.length;
        int p = 0;
        int q = 0;

        for (int i = 2; i <= N; i++) {
            int temp = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = temp;
        }

        return q;
    }

    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[N];
    }
}
