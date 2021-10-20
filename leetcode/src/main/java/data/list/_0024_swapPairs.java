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
        _0024_swapPairs solution = new _0024_swapPairs();

        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;

        cur.next = new ListNode(3);
        cur = cur.next;

        cur.next = new ListNode(4);
        cur = cur.next;

        ListNode res = solution.swapPairs1(head);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
        System.out.println();
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

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode leftPre = newHead;
        while (leftPre.next != null && leftPre.next.next != null) {
            ListNode left = leftPre.next;
            ListNode right = leftPre.next.next;
            ListNode rightNext = right.next;

            leftPre.next = right;
            right.next = left;
            left.next = rightNext;

            leftPre = left;
        }
        return newHead.next;
    }
}
