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
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while (node1 != null || node2 != null) {
            int n1 = node1 == null ? 0 : node1.val;
            int n2 = node2 == null ? 0 : node2.val;

            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
