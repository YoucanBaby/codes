package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 18:36
 * @Description:
 */
public class _0024_swapPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;

        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = pre.next.next;

            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
        }
        return newHead.next;
    }
}
