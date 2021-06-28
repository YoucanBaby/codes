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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftHead = head;
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(leftHead);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        // 判断哪个链表还有没被比较完的值，直接把cur指针指向它
        if (h1 != null) {
            cur.next = h1;

        }
        if (h2 != null) {
            cur.next = h2;
        }

        return dummy.next;
    }
}
