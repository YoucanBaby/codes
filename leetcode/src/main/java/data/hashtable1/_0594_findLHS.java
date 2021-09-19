package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 20:05
 * @Description:
 */
public class _0594_findLHS {

    public static void main(String[] args) {

    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num - 1));
            }
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
        }
        return res;
    }
}
