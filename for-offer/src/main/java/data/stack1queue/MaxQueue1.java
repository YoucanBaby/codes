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
class MaxQueue1 {

    Deque<Integer> deque;

    public MaxQueue1() {
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        int N = deque.size();
        int max = -1;
        for (int i = 0; i < N; i++) {
            int temp = deque.removeFirst();
            max = Math.max(max,temp);
            deque.addLast(temp);
        }
        return max;
    }

    public void push_back(int value) {
        deque.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            return deque.removeFirst();
        }
    }
}