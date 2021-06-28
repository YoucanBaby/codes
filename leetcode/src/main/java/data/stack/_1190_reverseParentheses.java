package data.stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 14:43
 * @Description:
 */
public class _1190_reverseParentheses {

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        _1190_reverseParentheses solution = new _1190_reverseParentheses();

        System.out.println(solution.reverseParentheses(s));
        System.out.println(solution.reverseParentheses2(s));
        System.out.println(solution.reverseParentheses3(s));
    }

    public String reverseParentheses3(String s) {
        int N = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int[] pair = new int[s.length()];
        Arrays.fill(pair, - 1);

        // 预括号处理
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

        int index = 0;
        int step = 1;        // 遍历的方向，1是左，-1是右
        StringBuilder sb = new StringBuilder();

        while (index < N) {
            char c = s.charAt(index);
            if (c == '(' || c == ')') {
                index = pair[index];
                step = -step;           // 更改遍历方向
            } else {
                sb.append(c);
            }
            index += step;
        }
        return sb.toString();
    }


    public String reverseParentheses2(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.removeFirst());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new LinkedList<>();
        int N = s.length();

        for (int i = 0; i < N; i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.addFirst(i);
            } else if (c == ')') {
                int j = stack.removeFirst();
                String tempS = sb.substring(j, i + 1);
                StringBuilder tempSb = new StringBuilder(tempS);
                tempSb.reverse();
                sb.replace(j, i + 1, tempSb.toString());
            }
        }

        // 替换掉所有左括号和右括号
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(' || c == ')') {
                continue;
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }
}
