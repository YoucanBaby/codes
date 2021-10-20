package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 02:47
 * @Description:
 */
public class _0086_partition {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallNode = smallHead;

        ListNode bigHead = new ListNode(0);
        ListNode bigNode = bigHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallNode.next = cur;
                cur = cur.next;
                smallNode = smallNode.next;
            } else {
                bigNode.next = cur;
                cur = cur.next;
                bigNode = bigNode.next;
            }
        }
        smallNode.next = bigHead.next;
        bigNode.next = null;

        return smallHead.next;
    }
}
