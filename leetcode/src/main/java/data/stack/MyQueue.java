package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 20:02
 * @Description:
 */
class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.addFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.removeFirst();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.getFirst();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
