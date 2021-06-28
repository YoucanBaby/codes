package data.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 14:06
 * @Description:
 */
public class _0316_removeDuplicateLetters {

    public static void main(String[] args) {
        String s = "cbacdcbc";
        _0316_removeDuplicateLetters solution = new _0316_removeDuplicateLetters();

        System.out.println(solution.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        int N = s.length();
        char[] arr = s.toCharArray();

        // 记录每个字符最后一次出现的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < N; i++) {
            char c = arr[i];
            lastIndex[c - 'a'] = i;
        }

        Deque<Character> stack = new LinkedList<>();
        // 记录每个字符是否在栈中出现
        boolean[] visited = new boolean[26];

        // 遍历数组
        for (int i = 0; i < N; i++) {
            char c = arr[i];
            // 如果遇到栈中重复的字符，就丢弃
            if (visited[c - 'a']) {
                continue;
            }

            // 如果 当前字符<栈顶元素 并且 之后还能看见该字符
                // 出栈
                // 维护visited
            // 上述代码需要反复执行
            while (!stack.isEmpty() && c < stack.getFirst() && i < lastIndex[stack.getFirst() - 'a']) {
                char top = stack.removeFirst();
                visited[top - 'a'] = false;
            }

            // 入栈
            // 维护visited
            stack.addFirst(c);
            visited[c - 'a'] = true;
        }

        // 把栈中元素添加到sb
        // 返回
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
