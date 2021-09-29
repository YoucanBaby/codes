package algorithm.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 09:35
 * @Description:
 */
public class _1353_maxEvents {

    public static void main(String[] args) {
        int[][] events = {
                {1,2},
                {2,3},
                {3,4}
        };
        _1353_maxEvents solution = new _1353_maxEvents();

        System.out.println(solution.maxEvents(events));
    }


    public int maxEvents(int[][] events) {
        int N = events.length;
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        for (int i = 0, day = 1; day <= 1e5; day++) {
            while (!pq.isEmpty() && pq.peek()[1] < day) {
                pq.remove();
            }
            while (i < N && events[i][0] == day) {
                pq.add(events[i++]);
            }
            if (!pq.isEmpty()) {
                pq.remove();
                count++;
            }
        }
        return count;
    }
}
