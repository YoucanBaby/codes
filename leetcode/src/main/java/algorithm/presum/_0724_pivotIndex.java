package algorithm.presum;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 00:58
 * @Description:
 */
public class _0724_pivotIndex {

    public int pivotIndex(int[] nums) {
        int N = nums.length;

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < N; i++) {
            if (sum - nums[i] - leftSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
