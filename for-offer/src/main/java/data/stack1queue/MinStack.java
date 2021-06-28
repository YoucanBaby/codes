package data.stack1queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 20:38
 * @Description:
 */
class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int val) {
        int min = 0;
        if (stack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, minStack.getFirst());
        }
        minStack.addFirst(min);
        stack.addFirst(val);
    }

    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        return stack.getFirst();
    }

    public int min() {
        return minStack.getFirst();
    }
}
