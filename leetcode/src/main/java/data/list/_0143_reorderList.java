package data.list;

import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 14:57
 * @Description:
 */
public class _0143_reorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;

        _0143_reorderList solution = new _0143_reorderList();
        solution.reorderList(head);

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    // 快慢指针找中点，从中点断开链表，再反转后一半的链表，最后合并两个链表
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode left = head;
        ListNode right = pre;
        ListNode newHead = new ListNode(0);
        cur = newHead;
        while (right != null) {
            cur.next = left;
            cur = cur.next;
            left = left.next;

            cur.next = right;
            cur = cur.next;
            right = right.next;
        }
        if (left != null) {
            cur.next = left;
        }
    }
}
