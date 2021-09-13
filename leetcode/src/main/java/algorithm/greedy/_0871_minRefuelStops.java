package algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 12:29
 * @Description:
 */
public class _0871_minRefuelStops {

    public static void main(String[] args) {
        int[][] stations = {
                {10,60}, {20,30}, {30,30}, {60,40}
        };
        int target = 100;
        int startFuel = 10;
        _0871_minRefuelStops solution = new _0871_minRefuelStops();

        System.out.println(solution.minRefuelStops(target, startFuel, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int reach = startFuel;      // 当前能够到达的位置
        int i = 0;                  // 当前到达加油站的下标
        int res = 0;
        while (reach < target) {
            while (i < N && stations[i][0] <= reach) {
                pq.add(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) return -1;
            reach += pq.remove();
            res++;
        }
        return res;
    }
}
