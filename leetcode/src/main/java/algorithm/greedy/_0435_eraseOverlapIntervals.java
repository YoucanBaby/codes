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
        int N = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int count = 0;
        int left = intervals[N - 1][0];         // 左边界
        for (int i = N - 2; i >= 0; i--) {
            if (intervals[i][1] <= left) {
                left = intervals[i][0];
            } else {
                count++;
            }
        }
        return count;
    }
}
