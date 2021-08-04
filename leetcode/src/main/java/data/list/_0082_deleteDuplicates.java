package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 19:34
 * @Description:
 */
public class _0082_deleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode left = newHead;        // left.next是相同节点的下一个节点

        while (left.next != null && left.next.next != null) {
            if (left.next.val == left.next.next.val) {
                ListNode right = left.next.next;

                // 找到相同节点的右边界
                while (right.next != null && right.val == right.next.val) {
                    right = right.next;
                }
                // 删除这些相同的节点
                left.next = right.next;
            } else {
                left = left.next;
            }
        }

        return newHead.next;
    }


    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode left = newHead;        // 保证left.next是相同节点的下一个节点

        while (left.next != null && left.next.next != null) {
            ListNode right = left.next;
            while (right.next != null && right.val == right.next.val) {
                right = right.next;
            }
            if (left.next != right) {
                left.next = right.next;
            } else {
                left = left.next;
            }
        }
        return newHead.next;
    }
}
