package data.list;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 11:06
 * @Description:
 */
public class _0369_plusOne {



    public ListNode plusOne(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode not9 = newHead;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val != 9) {
                not9 = cur;
            }
        }
        not9.val += 1;

        for (ListNode cur = not9.next; cur != null; cur = cur.next) {
            cur.val = 0;
        }

        return newHead.val == 1 ? newHead : newHead.next;
    }
}
