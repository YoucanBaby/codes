package data.list;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 18:47
 * @Description:
 */
public class _0445_addTwoNumbers {

    // 用双端队列存放数字，左高右低
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        while (node1 != null) {
            deque1.addLast(node1.val);
            node1 = node1.next;
        }
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (node2 != null) {
            deque2.addLast(node2.val);
            node2 = node2.next;
        }

        ListNode newHead = new ListNode(0);
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int num1 = deque1.isEmpty() ? 0 : deque1.removeLast();
            int num2 = deque2.isEmpty() ? 0 : deque2.removeLast();

            int sum = num1 + num2 + carry;
            ListNode cur = new ListNode(sum % 10);
            cur.next = newHead.next;
            newHead.next = cur;

            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode cur = new ListNode(1);
            cur.next = newHead.next;
            newHead.next = cur;
        }
        return newHead.next;
    }
}
