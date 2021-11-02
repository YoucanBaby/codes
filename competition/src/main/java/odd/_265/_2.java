package odd._265;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._265
 * @author: xuyifang
 * @CreateTime: 2021-10-31-10:26
 * @description:
 * @version: 1.0
 */
public class _2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1,-1};
        }

        List<Integer> list = new ArrayList<>();

        int index = 1;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            if (pre.val < cur.val && cur.val > cur.next.val) {
                list.add(index);
            }
            if (pre.val > cur.val && cur.val < cur.next.val) {
                list.add(index);
            }
            index++;
            pre = pre.next;
            cur = cur.next;
        }

        if (list.size() < 2) {
            return new int[] {-1,-1};
        }

        int[] res = new int[2];
        res[1] = list.get(list.size() - 1) - list.get(0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        res[0] = min;
        return res;
    }
}
