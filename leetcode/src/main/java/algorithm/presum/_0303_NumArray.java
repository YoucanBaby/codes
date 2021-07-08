package algorithm.presum;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 01:15
 * @Description:
 */
public class _0303_NumArray {
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            int N = nums.length;
            preSum = new int[N + 1];
            for (int i = 0; i < N; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
