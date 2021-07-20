package algorithm.greedy;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 09:09
 * @Description:
 */
public class _1877_minPairSum {

    // 把`第k大的`和`第k小的`拼在一起，可以使得`最大和`最小。
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int left = 0;
        int right = N - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }

        return max;
    }
}
