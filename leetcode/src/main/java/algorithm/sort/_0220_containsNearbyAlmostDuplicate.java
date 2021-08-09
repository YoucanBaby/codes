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

    long size = 0;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int N = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        size = t + 1L;

        for (int i = 0; i < N; i++) {
            long u = nums[i] * 1L;
            long index = getIdx(u);

            // 目标桶是否存在
            if (map.containsKey(index)) {
                return true;
            }

            // 检查相邻的桶
            long left = index - 1;
            long right = index + 1;
            if (map.containsKey(left) && u - t <= map.get(left)) {
                return true;
            }
            if (map.containsKey(right) && map.get(right) <= u + t) {
                return true;
            }

            map.put(index, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) {
                map.remove(getIdx(nums[i - k]) * 1L);
            }
        }

        return false;
    }

    private long getIdx(long u) {
        if (u >= 0) {
            return u / size;
        } else {
            return (u + 1) / size - 1;
        }
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
