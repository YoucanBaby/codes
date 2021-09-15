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
            StringBuilder sb = new StringBuilder();
            Deque<StringBuilder> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(sb);
                    sb = new StringBuilder();
                } else if (c == ')') {
                    sb.reverse();
                    sb.insert(0, stack.pop());
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
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
                    stack.push(i);
                } else if (c == ')') {
                    int j = stack.pop();
                    pair[i] = j;
                    pair[j] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            int index = 0;
            int step = 1;               // 遍历的方向，1是左，-1是右
            while (index < N) {
                char c = s.charAt(index);
                if (c == '(' || c == ')') {
                    index = pair[index];
                    step = -step;       // 更改遍历方向
                } else {
                    sb.append(c);
                }
                index += step;
            }
            return sb.toString();
        }
    }
}



