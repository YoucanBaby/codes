package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 15:46
 * @Description:
 */
public class _0253_minMeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {
                {2,11},
                {6,16},
                {11,16}
        };
        _0253_minMeetingRooms solution = new _0253_minMeetingRooms();

        System.out.println(solution.minMeetingRooms(intervals));
    }


    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            pq.add(new int[] {interval[0], 1});
            pq.add(new int[] {interval[1], -1});
        }

        int count = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            count += pq.remove()[1];
            res = Math.max(res, count);
        }
        return res;
    }
}
