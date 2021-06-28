package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 20:59
 * @Description:
 */
public class _0142_detectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;
        ListNode cycle =cur;

        cur.next = new ListNode(0);
        cur = cur.next;
        cur.next = new ListNode(-4);
        cur = cur.next;
        cur.next = cycle;

        _0142_detectCycle solution = new _0142_detectCycle();
        cur = solution.detectCycle(head);

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
