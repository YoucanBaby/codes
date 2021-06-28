package data.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 07:09
 * @Description:
 */
public class MyStack2 {
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    /** Initialize your data structure here. */
    public MyStack2() {
        deque1 = new LinkedList<Integer>();
        deque2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque2.addFirst(x);
        while (!deque1.isEmpty()) {
            deque2.addFirst(deque1.removeLast());
        }
        deque1 = deque2;
        deque2 = new LinkedList<Integer>();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque1.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return deque1.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque1.isEmpty();
    }
}
