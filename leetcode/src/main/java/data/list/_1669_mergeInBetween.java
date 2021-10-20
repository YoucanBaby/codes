package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-04 11:56
 * @Description:
 */
public class _1669_mergeInBetween {


    public ListNode mergeInBetween(ListNode node1, int a, int b, ListNode node2) {
        ListNode newHead = new ListNode(0, node1);
        ListNode leftNodePre = newHead;
        for (int i = 0; i < a; i++) {
            leftNodePre = leftNodePre.next;
        }

        ListNode rightNode = newHead;
        for (int i = 0; i <= b; i++) {
            rightNode = rightNode.next;
        }
        ListNode rightNodeNext = rightNode.next;

        leftNodePre.next = node2;
        ListNode cur = node2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = rightNodeNext;

        return newHead.next;
    }
}
