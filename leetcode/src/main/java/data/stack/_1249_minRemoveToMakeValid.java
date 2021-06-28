package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 04:56
 * @Description:
 */
public class _1249_minRemoveToMakeValid {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        _1249_minRemoveToMakeValid solution = new _1249_minRemoveToMakeValid();

        System.out.println(solution.minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    if (s.charAt(stack.getFirst()) == '(') {
                        stack.removeFirst();
                    } else if (s.charAt(stack.getFirst()) == ')') {
                        stack.addFirst(i);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && i == stack.getLast()) {
                stack.removeLast();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
