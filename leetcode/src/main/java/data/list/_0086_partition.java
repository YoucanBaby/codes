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
        ListNode samllHead = new ListNode(0);
        ListNode small = samllHead;

        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        small.next = largeHead.next;
        large.next = null;

        return samllHead.next;
    }
}
