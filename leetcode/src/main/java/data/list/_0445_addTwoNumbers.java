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


    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        // 左低右高
        Deque<Integer> deque1 = new ArrayDeque<>();
        ListNode cur1 = node1;
        while (cur1 != null) {
            deque1.addFirst(cur1.val);
            cur1 = cur1.next;
        }
        Deque<Integer> deque2 = new ArrayDeque<>();
        ListNode cur2 = node2;
        while (cur2 != null) {
            deque2.addFirst(cur2.val);
            cur2 = cur2.next;
        }

        ListNode cur = new ListNode();
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int n1 = deque1.isEmpty() ? 0 : deque1.removeFirst();
            int n2 = deque2.isEmpty() ? 0 : deque2.removeFirst();

            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            cur.val = sum;
            ListNode pre = new ListNode(0, cur);
            cur = pre;
        }
        if (carry == 1) {
            cur.val = 1;
            ListNode pre = new ListNode(0, cur);
            cur = pre;
        }

        return cur.next;
    }
}
