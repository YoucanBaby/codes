package data.list;

import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 01:42
 * @Description:
 */
public class _0147_insertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        _0147_insertionSortList solution = new _0147_insertionSortList();

        cur = solution.insertionSortList(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode node2 = head.next;
        head.next = null;

        while (node2 != null) {
            ListNode node1 = newHead;
            while (node1.next != null && node1.next.val < node2.val) {
                node1 = node1.next;
            }
            ListNode temp = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node2 = temp;
        }
        return newHead.next;
    }
}
