package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-26 22:15
 * @Description:
 */
public class _0096_numTrees {

    public int numTrees(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] += dp[i - k] * dp[k - 1];
            }
        }
        return dp[N];
    }
}
