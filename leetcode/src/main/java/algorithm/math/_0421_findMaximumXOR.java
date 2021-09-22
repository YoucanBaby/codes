package algorithm.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 11:36
 * @Description:
 */
public class _0421_findMaximumXOR {

    public static void main(String[] args) {
        _0421_findMaximumXOR solution = new _0421_findMaximumXOR();

        int[] nums = {2,3,5};
        System.out.println(solution.findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int bestRes = res | (1 << i);
            for (int s : set) {
                if (set.contains(s ^ bestRes)) {
                    res = bestRes;
                    break;
                }
            }
        }
        return res;
    }
}
