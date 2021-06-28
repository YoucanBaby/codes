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

    public static void main(String[] args) {

    }

    long size = 0;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int N = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;

        for (int i = 0; i < N; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);

            // 目标桶是否存在
            if (map.containsKey(idx)) {
                return true;
            }

            // 检查相邻的桶
            long left = idx - 1;
            long right = idx + 1;
            if (map.containsKey(left) && u - t <= map.get(left)) {
                return true;
            }
            if (map.containsKey(right) && map.get(right) <= u + t) {
                return true;
            }

            map.put(idx, u);
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

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int N = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            Long num = set.ceiling((long) nums[i] - (long) t);
            if (num != null && num <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
