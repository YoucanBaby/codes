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
            for (int k = 1; k <= i - 1; k++) {
                dp[i] = max(
                        dp[i],
                        k * (i - k),
                        k * dp[i - k]
                );
            }
        }
        return dp[n];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
