package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 11:18
 * @Description:
 */
public class _0056_merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int right = list.get(list.size() - 1)[1];
            if (right >= intervals[i][0]) {
                int max = Math.max(right, intervals[i][1]);
                list.get(list.size() - 1)[1] = max;
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][0]);
    }
}
