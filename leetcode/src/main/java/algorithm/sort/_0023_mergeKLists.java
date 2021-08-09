package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-09 02:16
 * @Description:
 */
public class _0023_mergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode leftHead = mergeSort(lists, left, mid);
        ListNode rightHead = mergeSort(lists, mid + 1, right);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;

        }
        if (node2 != null) {
            cur.next = node2;
        }
        return newHead.next;
    }
}
