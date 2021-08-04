package data.list;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-04 11:56
 * @Description:
 */
public class _1669_mergeInBetween {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode newHead = new ListNode(0, list1);

        ListNode left = newHead;
        for (int i = 0; i < a; i++) {
            left = left.next;
        }

        ListNode right = newHead;
        for (int i = 0; i <= b; i++) {
            right = right.next;
        }

        ListNode last = list2;
        while (last.next != null) {
            last = last.next;
        }

        left.next = list2;
        last.next = right.next;

        return newHead.next;
    }
}
