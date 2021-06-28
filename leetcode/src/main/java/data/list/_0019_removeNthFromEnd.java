package data.list;

import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 18:16
 * @Description:
 */
public class _0019_removeNthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // 为了防止头节点被删除，所以需要在头节点的前面引入新的头节点
        ListNode newHead = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = newHead;

        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 快慢指针一同走，直到fast为null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除第n个节点
        slow.next = slow.next.next;

        return newHead.next;
    }

    public int kthToLast(ListNode head, int k) {
        if (head.next == null) {
            return head.val;
        }

        // 为了防止头节点被删除，所以需要在头节点的前面引入新的头节点
        ListNode slow = head;
        ListNode fast = head;

        // 快指针先走n步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // 快慢指针一同走，直到fast为null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }
}
