package data.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 13:00
 * @Description:
 */
public class _0402_removeKdigits {

    public static void main(String[] args) {
        String num = "10";
        int k = 1;
        _0402_removeKdigits solution = new _0402_removeKdigits();

        System.out.println(solution.removeKdigits(num, k));
    }

    public String removeKdigits1(String num, int k) {
        // 新建栈，保留n-k个数
        // 从头开始循环
            // 如果当前的数>栈顶元素，则栈顶元素出栈
            // 如果栈的大小+数组剩余个数==n-k，则把数组剩余的数全部入栈
            // 入栈
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        while (!stack.isEmpty()) {
            char c = stack.pollLast();
            if (c > '0') {
                leadingZero = false;
            }
            if (leadingZero == false) {
                sb.append(c);
            }
        }

        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }


    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() != 0 && c < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (c == '0' && sb.length() == 0) continue;
            sb.append(c);
        }

        String res = sb.substring(0, Math.max(sb.length() - k, 0));
        return res.length() == 0 ? "0" : res;
    }
}
