package data.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-09-15 18:46
 * @Description:
 */
public class _0735_asteroidCollision {


    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int as : asteroids) {
            if (as > 0) {
                stack.push(as);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && as + stack.peek() < 0) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(as);
            } else if (as + stack.peek() == 0) {
                stack.pop();
            }
        }

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.removeLast();
        }
        return res;
    }
}
