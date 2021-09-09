package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-07 21:03
 * @Description:
 */
public class _0740_deleteAndEarn {

    public static void main(String[] args) {
        _0740_deleteAndEarn solution = new _0740_deleteAndEarn();

        int[] nums = {3,2,4};
        System.out.println(solution.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[N - 1];
    }


}
