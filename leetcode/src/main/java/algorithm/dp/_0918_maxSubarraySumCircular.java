package algorithm.dp;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 20:14
 * @Description:
 */
public class _0918_maxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int pre = (int) -1e9;
        int max = (int) -1e9;
        int sum = 0;

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
            sum += num;
        }

        int min = 0;
        pre = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            pre = Math.min(pre + nums[i], nums[i]);
            min = Math.min(pre, min);
        }

        return Math.max(max, sum - min);
    }
}
