package data.hashtable1;

import java.util.TreeMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 12:02
 * @Description:
 */
public class _0327_countRangeSum {


    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> treeMap = new TreeMap<>();	// <区间和, 这个区间和出现的次数>
        treeMap.put(0L, 1);

        int res = 0;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
            // [sum - upper, sum - lower]两边都能取到
            for (int count : treeMap.subMap(sum - upper, true, sum - lower, true).values()) {
                res += count;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
