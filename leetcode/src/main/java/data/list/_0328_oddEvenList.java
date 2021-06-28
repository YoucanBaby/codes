package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 02:20
 * @Description:
 */
public class _0328_oddEvenList {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;

        ListNode oddNode = head;
        ListNode evenNode = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;

        return head;
    }
}
