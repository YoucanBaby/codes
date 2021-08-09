package algorithm.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 17:31
 * @Description:
 */
public class _0057_insert {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        _0057_insert solution = new _0057_insert();

        int[][] res = solution.insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        int[][] res1 = solution.insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res1[i]));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        int N = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;

        while (i < N && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < N && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < N) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[0][0]);
    }
}
