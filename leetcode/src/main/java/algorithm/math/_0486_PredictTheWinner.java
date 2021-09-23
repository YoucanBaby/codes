package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 17:15
 * @Description:
 */
public class _0486_PredictTheWinner {



    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][N - 1] >= 0;
    }
}
