package algorithm.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 07:38
 * @Description:
 */
public class _0220_containsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer l = ts.floor(nums[i]);
            if (l != null && nums[i] - l <= t) return true;
            Integer r = ts.ceiling(nums[i]);
            if (r != null && r - nums[i] <= t) return true;
            ts.add(nums[i]);
            if (ts.size() > k) ts.remove(nums[i - k]);
        }
        return false;
    }


    class Solution {
        long size = 0;      // 桶的大小

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            HashMap<Long, Long> map = new HashMap<>();
            size = t + 1L;
            for (int i = 0; i < nums.length; i++) {
                long num = nums[i] * 1L;
                long index = getIdx(num);
                if (map.containsKey(index)) {   // 目标桶是否存在
                    return true;
                }

                long left = index - 1;
                long right = index + 1;         // 检查相邻的桶
                if (map.containsKey(left) && num - t <= map.get(left)) {
                    return true;
                }
                if (map.containsKey(right) && map.get(right) <= num + t) {
                    return true;
                }

                map.put(index, num);
                if (i >= k) {
                    map.remove(getIdx(nums[i - k]) * 1L);   // 移除下标范围不在[max(0, i - k), i)内的桶,
                }
            }
            return false;
        }

        private long getIdx(long num) {
            return num >= 0 ? num / size : (num + 1) / size - 1;
        }
    }
}
