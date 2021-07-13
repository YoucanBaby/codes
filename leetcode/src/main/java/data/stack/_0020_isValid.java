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
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.getFirst() != map.get(c)) {
                    return false;
                }
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
