package algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

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
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int[][] ret = new int[N + 1][2];

        // ret的下标
        int idx = 0;
        // intervals的下标
        int i = 0;

        // 将新区间左边且相离的区间加入结果集
        while (i < N && intervals[i][1] < newInterval[0]) {
            ret[idx++] = intervals[i++];
        }

        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i < N && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ret[idx++] = newInterval;

        // 最后将新区间右边且相离的区间加入结果集
        while (i < N) {
            ret[idx++] = intervals[i++];
        }

        return Arrays.copyOf(ret, idx);
    }
}
