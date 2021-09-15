package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 17:06
 * @Description:
 */
public class _0032_longestValidParentheses {

    public static void main(String[] args) {
        String s = ")()()";
        _0032_longestValidParentheses solution = new _0032_longestValidParentheses();
        System.out.println(solution.longestValidParentheses(s));
    }



    public int longestValidParentheses(String s) {
        int max = 0;

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            if (c == ')') right++;
            if (left == right) max = Math.max(max, left + right);
            if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') left++;
            if (c == ')') right++;
            if (left == right) max = Math.max(max, left + right);
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
