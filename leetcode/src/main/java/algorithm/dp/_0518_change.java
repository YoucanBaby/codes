package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-30 21:49
 * @Description:
 */
public class _0518_change {


    public int change(int target, int[] nums) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
