package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-29 02:53
 * @Description:
 */
public class _0014_cuttingRope {


    // dp
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], temp);
            }
        }

        return dp[n];
    }

    // 贪心
    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int MOD = (int) (1e9 + 7);
        long res = 1;
        while (n > 4) {
            res = (res * 3) % MOD;
            n -= 3;
        }

        return (int) (res * n % MOD);
    }
}
