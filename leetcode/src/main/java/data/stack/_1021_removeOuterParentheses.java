package data.stack;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 04:18
 * @Description:
 */
public class _1021_removeOuterParentheses {

    public static void main(String[] args) {
        String s = "(()())(())";
        _1021_removeOuterParentheses solution = new _1021_removeOuterParentheses();

        System.out.println(solution.removeOuterParentheses(s));
        System.out.println(solution.removeOuterParentheses2(s));
    }

    public String removeOuterParentheses2(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') level--;
            if (level >= 1) sb.append(c);
            if (c == '(') level++;
        }
        return sb.toString();
    }


    public String removeOuterParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        // 记录栈每次为空时候的下标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = 0;
            if (c == '(') {
                stack.addFirst(i);
            } else if (c == ')') {
                j = stack.removeFirst();
            }
            if (stack.isEmpty()) {
                deque.addLast(j);
                deque.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != deque.getFirst()) {
                sb.append(s.charAt(i));
            } else {
                deque.removeFirst();
            }
        }
        return sb.toString();
    }
}
