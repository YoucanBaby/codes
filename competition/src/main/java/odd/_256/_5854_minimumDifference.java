package odd._256;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._256
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 10:30
 * @Description:
 */
public class _5854_minimumDifference {


    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int N = nums.length;
        int res = Integer.MAX_VALUE;
        for (int left = 0, right = k - 1; right < N; left++, right++) {
            res = Math.min(res, nums[right] - nums[left]);
        }
        return res;
    }
}
