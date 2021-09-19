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

        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                res = Math.max(res, i - map.get(count));
            }
        }
        return res;
    }
}
