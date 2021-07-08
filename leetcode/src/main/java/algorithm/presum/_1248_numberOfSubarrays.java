package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 01:57
 * @Description:
 */
public class _1248_numberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);		// 初始值

        int preSum = 0;
        int res = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] % 2 == 1) {
                preSum++;
            }
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
