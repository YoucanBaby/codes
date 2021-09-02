package algorithm.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 19:20
 * @Description:
 */
public class _0365_canMeasureWater {


    public boolean canMeasureWater(int x, int y, int target) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[] {0, 0});
        Set<Long> used = new HashSet<>();

        while (!stack.isEmpty()) {
            if (used.contains(getHash(stack.getLast()))) {
                stack.removeLast();
                continue;
            }

            used.add(getHash(stack.getLast()));
            int[] water = stack.removeLast();
            int remainX = water[0];
            int remainY = water[1];
            if (remainX == target || remainY == target || remainX + remainY == target) {
                return true;
            }

            stack.addLast(new int[] {remainX - Math.min(remainX, y - remainY),
                    remainY + Math.min(remainX, y - remainY)});
            stack.addLast(new int[] {remainX + Math.min(remainY, x - remainX),
                    remainY - Math.min(remainY, x - remainX)});

            stack.addLast(new int[] {x , remainY});
            stack.addLast(new int[] {remainX, y});
            stack.addLast(new int[] {0, remainY});
            stack.addLast(new int[] {remainX, 0});
        }
        return false;
    }

    private Long getHash(int[] water) {
        return (long) water[0] * 10000000 + water[1];
    }
}
