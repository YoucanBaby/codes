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

    public static void main(String[] args) {

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        treeMap.put(0L, 1);

        int res = 0;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
            for (int count : treeMap.subMap(sum - upper, true, sum - lower, true).values()) {
                res += count;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
