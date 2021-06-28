package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-13 05:51
 * @Description:
 */
public class _1047_removeDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";
        _1047_removeDuplicates solution = new _1047_removeDuplicates();

        System.out.println(solution.removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                char c = stack.pollLast();
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
