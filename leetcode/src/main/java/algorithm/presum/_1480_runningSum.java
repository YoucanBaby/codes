package algorithm.presum;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 01:08
 * @Description:
 */
public class _1480_runningSum {

    public int[] runningSum(int[] nums) {
        int N = nums.length;
        int[] preSum = new int [N + 1];

        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        return Arrays.copyOfRange(preSum, 1, N + 1);
    }

    public void preSum(int[] nums) {
        int N = nums.length;
        int[] preSum = new int [N + 1];

        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }
}
