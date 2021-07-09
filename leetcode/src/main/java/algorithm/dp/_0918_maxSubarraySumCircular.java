package algorithm.dp;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 20:14
 * @Description:
 */
public class _0918_maxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int dp = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            dp = Math.max(dp + num, num);
            max = Math.max(max, dp);
        }

        int min = 0;
        dp = 0;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.min(dp + nums[i], nums[i]);
            min = Math.min(dp, min);
        }

        return Math.max(max, sum - min);
    }
}
