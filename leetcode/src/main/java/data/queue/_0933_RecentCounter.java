package data.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 12:52
 * @Description:
 */
public class _0933_RecentCounter {

    class RecentCounter {
        Deque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.offer(t);
            while (t - deque.peek() > 3000) {
                deque.poll();
            }
            return deque.size();
        }
    }
}
