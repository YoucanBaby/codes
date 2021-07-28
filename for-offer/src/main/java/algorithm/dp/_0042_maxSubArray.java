package algorithm.dp;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-17 00:40
 * @Description:
 */
public class _0042_maxSubArray {

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
