package algorithm.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-17 19:48
 * @Description:
 */
public class _0219_containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                return true;
            } else {
                set.add(nums[right]);
            }
            if (set.size() > k) {
                set.remove(nums[right - k]);
            }
        }
        return false;
    }
}
