package algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.presum
 * @Author: xuyifang
 * @CreateTime: 2021-07-08 01:30
 * @Description:
 */
public class _0525_findMaxLength {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;

        int N = nums.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                preSum--;
            } else if (nums[i] == 1) {
                preSum++;
            }
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
