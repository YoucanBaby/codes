package algorithm.sort;


import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 22:09
 * @Description:
 */
public class _0148_sortList {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0, head);
        ListNode slow = newHead;
        ListNode fast = newHead.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = head;
        ListNode node2 = slow.next;
        slow.next = null;

        ListNode left = sortList(node1);
        ListNode right = sortList(node2);
        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return newHead.next;
    }
}
