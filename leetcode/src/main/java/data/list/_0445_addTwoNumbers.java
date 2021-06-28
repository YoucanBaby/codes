package data.list;

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

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        // 高位在左边，低位在右边
        ListNode cur1 = l1;
        while (cur1 != null) {
            deque1.addLast(cur1.val);
            cur1 = cur1.next;
        }

        // 高位在左边，低位在右边
        ListNode cur2 = l2;
        while (cur2 != null) {
            deque2.addLast(cur2.val);
            cur2 = cur2.next;
        }

        // 保存结果
        Deque<Integer> deque3 = new ArrayDeque<>();

        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int n1 = 0;
            if (!deque1.isEmpty()) {
                n1 = deque1.removeLast();
            }

            int n2 = 0;
            if (!deque2.isEmpty()) {
                n2 = deque2.removeLast();
            }

            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }

            // 高位在左边，低位在右边
            deque3.addFirst(sum);
        }

        if (carry == 1) {
            deque3.addFirst(1);
        }

        // 取出deque3中的数据，高位在左边，低位在右边
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (!deque3.isEmpty()) {
            cur.next = new ListNode(deque3.removeFirst());
            cur = cur.next;
        }
        return newHead.next;
    }
}
