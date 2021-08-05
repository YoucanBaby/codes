package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 12:32
 * @Description:
 */
public class _1721_swapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode leftNode = newHead;
        for (int i = 0; i < k; i++) {
            leftNode = leftNode.next;
        }

        ListNode fast = leftNode;
        ListNode slow = newHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int temp = slow.val;
        slow.val = leftNode.val;
        leftNode.val = temp;

        return newHead.next;
    }
}
