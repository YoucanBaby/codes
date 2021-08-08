package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-20 16:55
 * @Description:
 */
public class _0056_merge {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        _0056_merge solution = new _0056_merge();

        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }



    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (res.get(res.size() - 1)[1] >= intervals[i][0]) {
                int temp = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
                res.get(res.size() - 1)[1] = temp;
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
