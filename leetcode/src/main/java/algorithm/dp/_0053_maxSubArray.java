package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-05 12:08
 * @Description:
 */
public class _0053_maxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int num: nums) {
            // if (sum + nums[i] > nums[i])
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
