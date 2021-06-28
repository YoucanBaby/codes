package data.list;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 09:57
 * @Description:
 */
public class _0022_getKthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
