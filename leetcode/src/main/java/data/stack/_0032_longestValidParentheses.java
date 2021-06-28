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
//        String s = "())((())";
        String s = ")()()";
        _0032_longestValidParentheses solution = new _0032_longestValidParentheses();

        System.out.println(solution.longestValidParentheses(s));
        System.out.println(solution.longestValidParentheses1(s));
    }

    public int longestValidParentheses1(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int N = s.length();

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (right < left) {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }

    public int longestValidParentheses(String s) {
        int N = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        int ret = 0;

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(i);
            } else if (c == ')') {
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    ret = Math.max(ret, i - stack.getFirst());
                }
            }
        }
        return ret;
    }
}
