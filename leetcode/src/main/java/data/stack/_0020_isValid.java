package data.stack;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 21:45
 * @Description:
 */
public class _0020_isValid {

    public static void main(String[] args) {
        String s = "()[]{}";
        _0020_isValid solution = new _0020_isValid();

        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.getLast() == map.get(c)) {
                    stack.removeLast();
                } else {
                    return false;
                }
            } else {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }
}
