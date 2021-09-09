package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-10 00:05
 * @Description:
 */
public class _0413_numberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i >= 1; i--) {
            nums[i] -= nums[i - 1];
        }

        int res = 0;
        int left = 1;
        while (left < N) {
            int right = left;
            while (right < N && nums[left] == nums[right]) right++;
            int k = right - left;
            res += k * (k - 1) / 2;
            left = right;
        }
        return res;
    }
}
