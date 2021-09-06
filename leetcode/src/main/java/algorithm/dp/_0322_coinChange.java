package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-31 02:05
 * @Description:
 */
public class _0322_coinChange {

    public int coinChange(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                if (dp[j - nums[i]] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }

        if (dp[target] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[target];
        }
    }


    class Solution {
        public int coinChange(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, target + 1);
            dp[0] = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = nums[i]; j <= target; j++) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
            return dp[target] == target + 1 ? -1 : dp[target];
        }
    }
}
