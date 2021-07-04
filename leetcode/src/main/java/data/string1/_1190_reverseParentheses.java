package data.string1;

import java.lang.reflect.Parameter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 19:38
 * @Description:
 */
public class _1190_reverseParentheses {
    class Solution {
        public String reverseParentheses(String s) {
            StringBuilder sb = new StringBuilder(s);
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                if (sb.charAt(i) == '(') {
                    stack.addFirst(i);
                } else if (sb.charAt(i) == ')'){
                    int left = stack.removeFirst();
                    int right = i;

                    String tempS = sb.substring(left, right);
                    StringBuilder tempsb = new StringBuilder(tempS);
                    tempsb.reverse();
                    sb.replace(left, right, tempsb.toString());
                }
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
                    continue;
                } else {
                    res.append(sb.charAt(i));
                }
            }

            return res.toString();
        }
    }

    class Solution2 {
        public String reverseParentheses(String s) {

            Deque<Integer> stack = new ArrayDeque<>();
            int N = s.length();
            int[] pair = new int[N];

            for (int i = 0; i < N; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.addFirst(i);
                } else if (c == ')') {
                    int j = stack.removeFirst();
                    pair[i] = j;
                    pair[j] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            int index = 0;
            int step = 1;
            while (index < N) {
                char c = s.charAt(index);
                if (c == '(' || c == ')') {
                    index = pair[index];
                    step = -step;
                } else {
                    sb.append(c);
                }
                index += step;
            }

            return sb.toString();
        }
    }
}



