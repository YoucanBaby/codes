package data.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 06:50
 * @Description:
 */
class MyStack1 {

    Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack1() {
        deque = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addFirst(x);
        while (deque.getLast() != x) {
            deque.push(deque.removeLast());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.removeLast();
    }

    /** Get the top element. */
    public int top() {
       return deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
