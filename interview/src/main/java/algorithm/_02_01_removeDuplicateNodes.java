package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 04:48
 * @Description:
 */
public class _02_01_removeDuplicateNodes {

    public static void main(String[] args) {

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = pre.next.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }

        return head;
    }
}
