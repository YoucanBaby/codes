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
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') level++;
            if (level >= 2) sb.append(c);
            if (c == ')') level--;
        }
        return sb.toString();
    }
}
