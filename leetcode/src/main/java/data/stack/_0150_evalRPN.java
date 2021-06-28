package data.stack;

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
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        _0150_evalRPN solution = new _0150_evalRPN();

        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token: tokens) {
            if (isNumber(token)) {
                int num = Integer.valueOf(token);
                stack.addFirst(num);
            } else {
                int b = stack.removeFirst();
                int a = stack.removeFirst();
                if (token.equals("+")) {
                    stack.addFirst(a + b);
                } else if (token.equals("-")) {
                    stack.addFirst(a - b);
                } else if (token.equals("*")) {
                    stack.addFirst(a * b);
                } else if (token.equals("/")) {
                    stack.addFirst(a / b);
                }
            }
        }
        return stack.getFirst();
    }

    private boolean isNumber(String token) {
        return !(token.equals("+")|| token.equals("-")|| token.equals("*") || token.equals("/"));
    }
}
