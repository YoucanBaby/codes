package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 12:00
 * @Description:
 */
public class _0092_reverseBetween {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);

        // 左节点是走left-1步的节点
        ListNode leftNode = newHead;
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }

        // 右节点是走right+1步的节点
        ListNode rightNode = newHead;
        for (int i = 0; i < right + 1; i++) {
            rightNode = rightNode.next;
        }

        // 剩下的画图
        ListNode pre = rightNode;
        ListNode cur = leftNode.next;

        while (cur != rightNode) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        leftNode.next = pre;

        return newHead.next;
    }
}
