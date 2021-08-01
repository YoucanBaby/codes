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
        int pre = Integer.MIN_VALUE;

        for (int num : nums) {
            if (pre <= 0) {
                pre = num;
            } else {
                pre += num;
            }
            max = Math.max(max, pre);
        }
        return max;
    }
}
