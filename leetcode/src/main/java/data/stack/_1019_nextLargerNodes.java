package data.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 06:29
 * @Description:
 */
public class _1019_nextLargerNodes {


    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(list.size(), cur.val);
            cur = cur.next;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.getFirst())) {
                int index = stack.removeFirst();
                res[index] = list.get(i);
            }
            stack.addFirst(i);
        }
        return res;
    }
}
