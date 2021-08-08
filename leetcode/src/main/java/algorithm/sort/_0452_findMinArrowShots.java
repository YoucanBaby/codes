package algorithm.sort;

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 20:10
 * @Description:
 */
public class _0452_findMinArrowShots {

    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        _0452_findMinArrowShots solution = new _0452_findMinArrowShots();

        System.out.println(solution.findMinArrowShots(points));
    }

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
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (right < points[i][0]) {
                res++;
                right = points[i][1];
            }
        }
        return res;
    }
}
