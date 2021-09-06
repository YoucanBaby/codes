package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-06 00:37
 * @Description:
 */
public class _0312_maxCoins {


    public int maxCoins(int[] oldNums) {
        int[] nums = new int[oldNums.length + 2];
        int N = nums.length;
        nums[0] = 1;
        for (int i = 0; i < oldNums.length; i++) {
            nums[i + 1] = oldNums[i];
        }
        nums[N - 1] = 1;

        int[][] dp = new int[N][N];

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;

                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + nums[i] * nums[k] * nums[j] + dp[k][j]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
