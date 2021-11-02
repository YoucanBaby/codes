package odd._265;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._265
 * @author: xuyifang
 * @CreateTime: 2021-10-31-10:26
 * @description:
 * @version: 1.0
 */
public class _3 {

    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(start);

        int count = 1;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            int a = start + num;
            if (a == goal) return count;
            set.add(a);
            if (a >= 0 && a <= 1000) deque.addLast(a);

            int b = start - num;
            if (b == goal) return count;
            set.add(b);
            if (b >= 0 && b <= 1000) deque.addLast(b);

            int c = start ^ num;
            if (c == goal) return count;
            set.add(c);
            if (c >= 0 && c <= 1000) deque.addLast(c);
        }

        while (!deque.isEmpty()) {
            count++;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int now = deque.removeFirst();
                for (int num : nums) {
                    int a = now + num;
                    if (a == goal) return count;
                    if (!set.contains(a)) {
                        set.add(a);
                        if (a >= 0 && a <= 1000) deque.add(a);
                    }

                    int b = now - num;
                    if (b == goal) return count;
                    if (!set.contains(b)) {
                        set.add(b);
                        if (b >= 0 && b <= 1000) deque.add(b);
                    }

                    int c = now ^ num;
                    if (c == goal) return count;
                    if (!set.contains(c)) {
                        set.add(c);
                        if (c >= 0 && c <= 1000) deque.add(c);
                    }
                }
            }
        }
        return -1;
    }
}
