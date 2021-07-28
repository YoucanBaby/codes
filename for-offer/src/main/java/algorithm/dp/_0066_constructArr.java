package algorithm.dp;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 17:49
 * @Description:
 */
public class _0066_constructArr {

    public int[] constructArr(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = N - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            dp[i] *= temp;
        }

        return dp;
    }
}
