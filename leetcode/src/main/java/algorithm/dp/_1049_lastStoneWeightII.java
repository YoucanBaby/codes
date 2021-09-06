package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 12:56
 * @Description:
 */
public class _1049_lastStoneWeightII {

    public int lastStoneWeightII(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return (sum - dp[target]) - dp[target];
    }
}
