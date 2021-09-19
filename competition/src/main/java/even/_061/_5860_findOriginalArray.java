package even._061;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._061
 * @Author: xuyifang
 * @CreateTime: 2021-09-18 22:36
 * @Description:
 */
public class _5860_findOriginalArray {


    public int[] findOriginalArray(int[] nums) {
        if ((nums.length & 1) == 1) return new int[0];
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int N = nums.length;
        int[] res = new int[N/ 2];
        int i = 0;
        for (int num : nums) {
            if (map.getOrDefault(num, 0) != 0) {
                map.put(num, map.get(num) - 1);
                if (map.getOrDefault(num * 2, 0) != 0) {
                    res[i++] = num;
                    map.put(num * 2, map.get(num * 2) - 1);
                }
            }
        }
        return i == N /2 ? res : new int[0];
    }
}
