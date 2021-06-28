package data.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 21:18
 * @Description:
 */
public class _0682_calPoints {

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        _0682_calPoints solution = new _0682_calPoints();

        System.out.println(solution.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("C")) {
                deque.removeLast();
            } else if (s.equals("D")) {
                int num = 2 * deque.getLast();
                deque.addLast(num);
            } else if (s.equals("+")) {
                int b = deque.removeLast();
                int a = deque.getLast();
                deque.addLast(b);
                deque.addLast(a + b);
            } else {
                deque.addLast(Integer.valueOf(s));
            }
        }

        int ret = 0;
        while (!deque.isEmpty()) {
            ret += deque.removeLast();
        }
        return ret;
    }
}
