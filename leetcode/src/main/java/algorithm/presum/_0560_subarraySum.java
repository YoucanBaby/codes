package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 00:52
 * @Description:
 */
public class _0560_subarraySum {

    public int subarraySum(int[] nums, int goal) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        int res = 0;

        for (int num : nums) {
            sum += num;
            res += preSum.getOrDefault(sum - goal, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) +  1);
        }

        return res;
    }
}
