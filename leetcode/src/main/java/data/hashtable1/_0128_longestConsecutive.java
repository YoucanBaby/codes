package data.hashtable1;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 20:27
 * @Description:
 */
public class _0128_longestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,2,3};
        _0128_longestConsecutive solution = new _0128_longestConsecutive();

        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int length = 0;
                while (set.contains(cur)) {
                    cur++;
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
