package algorithm.find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 11:38
 * @Description:
 */
public class _0786_kthSmallestPrimeFraction {


    public int[] kthSmallestPrimeFraction(int[] nums, int k) {
        int N = nums.length;
        TreeMap<Double, int[]> treeMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                treeMap.put((double)nums[i] / nums[j], new int[]{nums[i], nums[j]});
            }
        }
        for (int i = 1; i < k; i++) {
            treeMap.remove(treeMap.firstKey());
        }
        return treeMap.get(treeMap.firstKey());
    }
}
