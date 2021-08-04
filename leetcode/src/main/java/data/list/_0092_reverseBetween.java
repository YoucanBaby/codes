package data.list;

import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 12:00
 * @Description:
 */
public class _0092_reverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);  // 反转前n个节点
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode next = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return last;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;

        _0092_reverseBetween solution = new _0092_reverseBetween();
        ListNode res = solution.reverseBetween(head, 2, 4);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode leftNode = newHead;        // 到左边界的前一个节点
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }
        ListNode rightNode = newHead;       // 到右边界的后一个节点
        for (int i = 0; i < right + 1; i++) {
            rightNode = rightNode.next;
        }

        // 反转链表
        ListNode[] temp = reverseList(leftNode, rightNode);
        leftNode.next = temp[0];
        temp[1].next = rightNode;

        return newHead.next;
    }

    // 返回反转之后链表的起始节点
    public ListNode[] reverseList(ListNode leftNode, ListNode rightNode) {
        ListNode pre = null;
        ListNode cur = leftNode.next;
        ListNode endNode = leftNode.next;

        while (cur != rightNode) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        ListNode startNode = pre;

        return new ListNode[] {startNode, endNode};
    }
}
