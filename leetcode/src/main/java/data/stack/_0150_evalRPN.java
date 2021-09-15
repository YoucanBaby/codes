package data.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 08:26
 * @Description:
 */
public class _0150_evalRPN {

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        _0150_evalRPN solution = new _0150_evalRPN();

        System.out.println(solution.evalRPN(tokens));
    }


    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+")) stack.push(a + b);
                if (s.equals("-")) stack.push(a - b);
                if (s.equals("*")) stack.push(a * b);
                if (s.equals("/")) stack.push(a / b);
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return ! (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
