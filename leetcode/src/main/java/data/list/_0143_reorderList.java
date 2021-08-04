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


    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        // 快慢节点，找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后一半的链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        slow.next = null;       // 前一半的链表，最后一个节点要为null

        // 合并两个链表
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        ListNode node1 = head;
        ListNode node2 = pre;

        while (node1 != null && node2 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;

            node.next = node2;
            node2 = node2.next;
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
    }
}
