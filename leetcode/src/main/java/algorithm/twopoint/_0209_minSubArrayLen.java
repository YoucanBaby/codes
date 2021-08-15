package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 17:19
 * @Description:
 */
public class _0209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < N; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
