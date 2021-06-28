package data.stack1queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 11:02
 * @Description:
 */
class MaxQueue2 {

    Deque<Integer> deque;
    Deque<Integer> dequeMax;

    public MaxQueue2() {
        deque = new ArrayDeque<>();
        dequeMax = new ArrayDeque<>();
    }

    public int max_value() {
        if (dequeMax.isEmpty()) {
            return -1;
        } else {
            return dequeMax.getFirst();
        }
    }

    public void push_back(int value) {
        while (!dequeMax.isEmpty() && dequeMax.getLast() < value) {
            dequeMax.removeLast();
        }
        dequeMax.addLast(value);
        deque.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            // 当Integer大于127之后，需要使用equals()，而不能使用==
            if (deque.getFirst().equals(dequeMax.getFirst())) {
                dequeMax.removeFirst();
            }
            return deque.removeFirst();
        }
    }
}
