package data.stack1queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 10:49
 * @Description:
 */
public class _0059_MaxQueue {

    class MaxQueue {
        Deque<Integer> deque;
        Deque<Integer> maxDeque;

        public MaxQueue() {
            deque = new ArrayDeque<>();
            maxDeque = new ArrayDeque<>();
        }

        public int max_value() {
            return maxDeque.isEmpty() ? -1 : maxDeque.getFirst();
        }

        public void push_back(int val) {
            deque.addLast(val);
            while (!maxDeque.isEmpty() && val > maxDeque.getLast()) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(val);
        }

        public int pop_front() {
            if (deque.isEmpty()) {
                return -1;
            } else {
                if (deque.getFirst().equals(maxDeque.getFirst())) {
                    maxDeque.removeFirst();
                }
                return deque.removeFirst();
            }
        }
    }
}
