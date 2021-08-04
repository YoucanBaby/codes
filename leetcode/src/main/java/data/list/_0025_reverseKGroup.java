package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-04 19:28
 * @Description:
 */
public class _0025_reverseKGroup {


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

        _0025_reverseKGroup solution = new _0025_reverseKGroup();
        ListNode res = solution.reverseKGroup(head, 2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode leftNode = newHead;
        ListNode rightNode = newHead;
        for (int i = 0; i <= k; i++) {
            if (rightNode == null) {
                return newHead.next;
            }
            rightNode = rightNode.next;
        }
        ListNode[] temp = reverseList(leftNode, rightNode);
        leftNode.next = temp[0];
        temp[1].next = rightNode;


        while (rightNode != null) {
            for (int i = 0; i < k; i++) {
                if (rightNode == null) {
                    return newHead.next;
                }
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            }
            temp = reverseList(leftNode, rightNode);
            leftNode.next = temp[0];
            temp[1].next = rightNode;
        }

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

    class solution {
        public ListNode reverseKGroup (ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            return new ListNode(0);
        }
    }
}
