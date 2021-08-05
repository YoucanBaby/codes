package data.hashtable1;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-08-05 14:48
 * @Description:
 */
public class _0817_numComponents {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (set.contains(cur.val) &&
                    (cur.next == null || !set.contains(cur.next.val))) {
                res++;
            }
        }
        return res;
    }
}
