package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 10:10
 * @Description:
 */
public class _0435_eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int res = 0;
        int right = intervals[0][1];    // 右边界
        for (int i = 1; i < intervals.length; i++) {
            if (right <= intervals[i][0]) {
                right = intervals[i][1];
            } else {
                res++;
            }
        }
        return res;
    }
}
