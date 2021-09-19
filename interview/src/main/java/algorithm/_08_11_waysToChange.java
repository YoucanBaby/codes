package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 08:25
 * @Description:
 */
public class _08_11_waysToChange {


    public int waysToChange(int n) {
        int MOD = (int) (1e9 + 7);
        int[] nums = {1,5,10,25};
        long[] dp = new long[n + 1];
        dp[0] = 1L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j] += dp[j - nums[i]];
                dp[j] %= MOD;
            }
        }
        return (int) dp[n];
    }
}
