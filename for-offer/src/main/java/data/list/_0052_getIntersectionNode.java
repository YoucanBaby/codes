package data.list;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 12:59
 * @Description:
 */
public class _0052_getIntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            if (node1 == null) {
                node1 = headB;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }
}
