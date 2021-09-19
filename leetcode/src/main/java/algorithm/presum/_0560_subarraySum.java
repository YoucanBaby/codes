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

    public int subarraySum(int[] nums, int target) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int right = preSum[i];
            res += map.getOrDefault(right - target, 0);
            map.put(right, map.getOrDefault(right, 0) + 1);
        }
        return res;
    }
}
