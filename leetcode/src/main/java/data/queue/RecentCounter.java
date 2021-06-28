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
class RecentCounter {

    Deque<Integer> deque;

    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.addLast(t);

        while (t - deque.getFirst() > 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}
