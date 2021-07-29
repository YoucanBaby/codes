package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 14:11
 * @Description:
 */
public class _0494_findTargetSumWays {


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target > sum) {
            return 0;
        }
        if (((sum + target) & 1) == 1) {
            return 0;
        }

        int bigWeight = (sum + target) / 2;
        int[] dp = new int[bigWeight + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bigWeight; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bigWeight];
    }
}
