package data.list;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 09:38
 * @Description:
 */
public class _0018_deleteNode {

    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        ListNode pre = head;

        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        return head;
    }
}
