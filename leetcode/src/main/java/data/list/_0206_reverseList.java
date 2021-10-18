package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 12:22
 * @Description:
 */
public class _0206_reverseList {

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
