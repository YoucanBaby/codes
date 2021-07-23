package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 09:56
 * @Description:
 */
public class _0452_findMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        // compare里面不能直接相减，有大样例[2147483646,2147483647]的时候，会溢出
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] == o2[1]) {
                return 0;
            } else {
                return 1;
            }
        });

        int res = 1;
        int pivot = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (pivot < points[i][0]) {
                res++;
                pivot = points[i][1];
            }
        }
        return res;
    }
}
