package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 13:07
 * @Description:
 */
public class _0856_scoreOfParentheses {

    public static void main(String[] args) {
        String s = "(()(()))";
        _0856_scoreOfParentheses solution = new _0856_scoreOfParentheses();

        System.out.println(solution.scoreOfParentheses(s));
        System.out.println(solution.scoreOfParentheses1(s));
    }

    public int scoreOfParentheses1(String s) {
        int ret = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    ret += 1 << depth;
                }
            }
        }
        return ret;
    }


    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.addLast(0);
            } else if (c == ')') {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.addLast(a + Math.max(2 * b, 1));
            }
        }
        return stack.removeLast();
    }
}
