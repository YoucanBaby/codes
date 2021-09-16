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
        String[] ops = {"5","2","C","D","+"};
        _0682_calPoints solution = new _0682_calPoints();

        System.out.println(solution.calPoints(ops));
    }


    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int b = stack.pop();
                int a = stack.peek();
                stack.push(b);
                stack.push(a + b);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int res = 0;
        for (int num : stack) {
            res += num;
        }
        return res;
    }
}
