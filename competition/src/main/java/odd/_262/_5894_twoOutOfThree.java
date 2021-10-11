package odd._262;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._262
 * @Author: xuyifang
 * @CreateTime: 2021-10-10 10:30
 * @Description:
 */
public class _5894_twoOutOfThree {


    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> set3 = new HashSet<>();
        for (int num : nums3) {
            set3.add(num);
        }

        Set<Integer> res = new HashSet<>();
        for (int num : nums1) {
            if (set2.contains(num)) {
                res.add(num);
            } else if (set3.contains(num)) {
                res.add(num);
            }
        }
        for (int num : nums2) {
            if (set3.contains(num)) {
                res.add(num);
            }
        }
        return new ArrayList<>(res);
    }
}
