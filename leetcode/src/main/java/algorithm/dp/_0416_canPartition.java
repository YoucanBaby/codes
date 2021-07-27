package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-27 05:36
 * @Description:
 */
public class _0416_canPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum是奇数，返回false
        if ((sum & 1) == 1) {
            return false;
        }
        int bigWeight = sum / 2;

        int[] dp = new int[bigWeight + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bigWeight; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[bigWeight] == bigWeight;
    }
}
