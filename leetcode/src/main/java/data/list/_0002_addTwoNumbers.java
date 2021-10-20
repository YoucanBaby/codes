package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 11:25
 * @Description:
 */
public class _0002_addTwoNumbers {



    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        int carry = 0;

        while (cur1 != null || cur2 != null) {
            int num1 = cur1 == null ? 0 : cur1.val;
            int num2 = cur2 == null ? 0 : cur2.val;

            int sum = num1 + num2 + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;

            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return newHead.next;
    }
}
