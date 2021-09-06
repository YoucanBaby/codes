package algorithm.dfs和bfs;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-03 22:42
 * @Description:
 */
public class _0815_numBusesToDestination {


    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (s == t) {
            return 0;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();   // <公交站台，这个站台能通过的达公交路线>
        Map<Integer, Integer> dist = new HashMap<>();       // <公交路线，到达该公交路线的距离>
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (station == s) {
                    deque.addLast(i);
                    dist.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();      // 当前公交路线的下标
            int step = dist.get(cur);           // 到达当前公交路线的距离

            for (int station : routes[cur]) {
                if (station == t) {
                    return step;
                }

                Set<Integer> nextSet = map.getOrDefault(station, new HashSet<>());
                for (int next : nextSet) {
                    if (!dist.containsKey(next)) {
                        dist.put(next, step + 1);
                        deque.addLast(next);
                    }
                }
            }
        }
        return -1;
    }
}
