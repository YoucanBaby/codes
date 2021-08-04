package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 01:55
 * @Description:
 */
public class _0203_removeElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;

        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return newHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;

        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
