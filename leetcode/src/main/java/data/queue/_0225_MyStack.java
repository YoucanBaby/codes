package data.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 06:50
 * @Description:
 */
public class _0225_MyStack {

    class MyStack {
        Deque<Integer> deque1;
        Deque<Integer> deque2;

        public MyStack() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
        }

        public void push(int x) {
            deque2.offer(x);
            while (!deque1.isEmpty()) {
                deque2.offer(deque1.poll());
            }
            deque1 = deque2;
            deque2 = new ArrayDeque<>();
        }

        public int pop() {
            return deque1.poll();
        }

        public int top() {
            return deque1.peek();
        }

        public boolean empty() {
            return deque1.isEmpty();
        }
    }

    class MyStack1 {
        Deque<Integer> deque;

        public MyStack1() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.addFirst(x);
            while (deque.getLast() != x) {
                deque.addFirst(deque.removeLast());
            }
        }

        public int pop() {
            return deque.removeLast();
        }

        public int top() {
            return deque.getLast();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

}
