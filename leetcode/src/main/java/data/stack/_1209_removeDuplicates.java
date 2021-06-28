package data.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 12:42
 * @Description:
 */
public class _1209_removeDuplicates {

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        _1209_removeDuplicates solution = new _1209_removeDuplicates();

        System.out.println(solution.removeDuplicates(s, k));
    }



    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.addFirst(1);
            } else {
                int count = stack.removeFirst() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.addFirst(count);
                }
            }
        }
        return sb.toString();
    }
}
