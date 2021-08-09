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
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 0;
        int index = 0;              // 遍历数组
        int N = events.length;
        for (int day = 1; day <= 1e5; day++) {
            while (index < N && events[index][0] == day) {
                pq.add(events[index++][1]);
            }
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.remove();
            }
            if (!pq.isEmpty()) {
                pq.remove();
                res++;
            }
        }
        return res;
    }
}
