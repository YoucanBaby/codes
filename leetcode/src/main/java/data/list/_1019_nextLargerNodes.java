package data.list;

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

    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (ListNode cur = head; cur != null ; cur = cur.next) {
            while (!stack.isEmpty() && cur.val > list.get(stack.getFirst())) {
                int index = stack.removeFirst();
                list.set(index, cur.val);
            }

            list.add(cur.val);
            stack.addFirst(list.size() - 1);
        }

        for (int i: stack) {
            list.set(i, 0);
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }
}
