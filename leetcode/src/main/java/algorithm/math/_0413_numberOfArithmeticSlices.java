package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-10 00:05
 * @Description:
 */
public class _0413_numberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int N = nums.length;
        int[] dp = new int[N];
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int res = 0;
        for (int count : dp) {
            res += count;
        }
        return res;
    }
}
