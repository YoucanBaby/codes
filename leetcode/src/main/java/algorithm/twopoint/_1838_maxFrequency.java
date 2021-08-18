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
        long sum = 0;         // 总共的操作次数
        int res = 1;

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            sum += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (sum > k) {
                sum -= nums[right] - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
