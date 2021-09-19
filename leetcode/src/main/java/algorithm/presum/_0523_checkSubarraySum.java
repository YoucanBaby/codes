package algorithm.presum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        int[] preSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < preSum.length; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;
    }
}
