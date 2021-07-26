package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-26 18:26
 * @Description:
 */
public class _0343_integerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int res = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], res);
            }
        }

        return dp[n];
    }
}
