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
    }

    public int scoreOfParentheses(String s) {
        int res = 0;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                level++;
            else if (s.charAt(i) == ')') {
                level--;
                if (s.charAt(i - 1) == '(')
                    res += 1 << level;
            }
        }
        return res;
    }

}
