package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 14:11
 * @Description:
 */
public class _0494_findTargetSumWays {


    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || ((S + sum) & 1) == 1) {
            return 0;
        }

        int target = (S + sum) / 2;
        if (target < 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
