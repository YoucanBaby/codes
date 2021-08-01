package odd._252;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._252
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 14:07
 * @Description:
 */
public class _5833_countSpecialSubsequences {

    public int countSpecialSubsequences(int[] nums) {
        int MOD = (int) (1e9 + 7);
        long dp0 = 0;
        long dp1 = 0;
        long dp2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp0 = dp0 * 2 + 1;
                dp0 %= MOD;
            } else if (nums[i] == 1) {
                dp1 = dp1 * 2 + dp0;
                dp1 %= MOD;
            } else {
                dp2 = dp2 * 2 + dp1;
                dp2 %= MOD;
            }
        }
        return (int) dp2;
    }
}
