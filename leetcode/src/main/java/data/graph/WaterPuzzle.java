package data.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 01:38
 * @Description:
 */
public class WaterPuzzle {

    public int dfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        boolean[] visited = new boolean[100];
        visited[0] = true;
        int count = 0;

        while (!deque.isEmpty()) {
            count++;
            int cur = deque.removeFirst();
            int a = cur / 10;
            int b = cur % 10;

            List<Integer> nexts = createNexts(a, b);

            for (int next : nexts) {
                if (!visited[next]) {
                    deque.addLast(next);
                    visited[next] = true;

                    if (next / 10 == 4 || next % 10 == 4) {
                        return count;
                    }
                }
            }
        }
        return count;
    }

    public List<Integer> createNexts(int a, int b) {
        List<Integer> nexts = new ArrayList<>();

        // A桶加满水，B桶加满水
        nexts.add(5 * 10 + b);
        nexts.add(a + 3 * 10);
        // A桶水倒掉，B桶水倒掉
        nexts.add(0 * 10 + b);
        nexts.add(a * 10 + 0);
        // 把A桶水倒进B桶
        int x = Math.min(a, 3 - b);
        nexts.add((a - x) * 10 + (b + x));
        // 把B桶水倒进A桶
        int y = Math.min((5 - a), b);
        nexts.add((a + y) * 10 + (b - y));

        return nexts;
    }
}
