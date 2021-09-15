package data.stack;

import java.util.ArrayDeque;
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
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(i);
            }
            else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.getLast()) == '(') {
                    stack.removeLast();
                }
                else  {
                    stack.addLast(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.getFirst() == i) {
                stack.removeFirst();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
