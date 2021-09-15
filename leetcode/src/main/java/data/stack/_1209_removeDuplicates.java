package data.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 12:42
 * @Description:
 */
public class _1209_removeDuplicates {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        _1209_removeDuplicates solution = new _1209_removeDuplicates();

        System.out.println(solution.removeDuplicates(s, k));
    }



    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int count = stack.pop();
                if (count + 1 == k) {
                    sb.delete(i - k + 1, i + 1);
                    i -= k;
                } else {
                    stack.push(count + 1);
                }
            }
        }
        return sb.toString();
    }
}
