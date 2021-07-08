package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 03:09
 * @Description:
 */
public class _0523_checkSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        if (N <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);		// 初始值
        int preSum = 0;

        for (int i = 0; i < N; i++) {
            preSum += nums[i];
            preSum %= k;

            if (map.containsKey(preSum)) {
                if (i - map.get(preSum) >= 2) {
                    return true;
                }
            } else {
                map.put(preSum, i);
            }
        }
        return false;
    }
}
