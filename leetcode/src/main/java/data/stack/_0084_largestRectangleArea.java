package data.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 16:05
 * @Description:
 */
public class _0084_largestRectangleArea {

    public static void main(String[] args) {
//        int[] heights = {2,1,5,6,2,3,0};
        int[] heights = {2,1,2};
        _0084_largestRectangleArea solution = new _0084_largestRectangleArea();

        System.out.println(solution.largestRectangleArea(heights));
    }


    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] h = new int[N + 2];
        for (int i = 0; i < N; i++) {
            h[i + 1] = heights[i];
        }
        N += 2;

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = i - stack.peek() - 1;
                res = Math.max(res, height * width);
            }
            stack.push(i);
        }
        return res;
    }
}
