package algorithm.twopoint;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-19 03:47
 * @Description:
 */
public class _1838_maxFrequency {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        long total = 0;
        int L = 0;
        int res = 1;

        for (int R = 1; R < N; R++) {
            total += (long) (nums[R] - nums[R - 1]) * (R - L);
            while (total > k) {
                total -= nums[R] - nums[L];
                L++;
            }
            res = Math.max(res, R - L + 1);
        }

        return res;
    }
}
