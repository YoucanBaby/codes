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
        // 按照开始时间排序
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 结果，开始时间，events下标，events长度
        int ret = 0;
        int start = 1;
        int i = 0;
        int N = events.length;

        while (i < N || !pq.isEmpty()) {
            // 将开始时间相同的会议都加入到堆
            while (i < N && events[i][0] == start) {
                pq.add(events[i][1]);
                i++;
            }
            // 移除掉当前天数之前的所有会议
            while (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }
            // 顶上的就是要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                ret++;
            }
            start++;
        }
        return ret;
    }
}
