package data.stack1queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 19:49
 * @Description:
 */
class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.addFirst(value);
    }

    public int deleteHead() {
        // 如果stack2为空，则把stack1都弹出去，弹给stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        // 如果stack2还是空，则说明队列为空，返回-1
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.removeFirst();
        }
    }
}
