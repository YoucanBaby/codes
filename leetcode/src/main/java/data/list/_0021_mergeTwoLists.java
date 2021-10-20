package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 09:55
 * @Description:
 */
public class _0021_mergeTwoLists {


    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = node1;
        ListNode cur2 = node2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return head.next;
    }
}
