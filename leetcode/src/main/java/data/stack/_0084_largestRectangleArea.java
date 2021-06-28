package data.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 16:05
 * @Description:
 */
public class _0084_largestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {2,1,2};
        _0084_largestRectangleArea solution = new _0084_largestRectangleArea();

        System.out.println(solution.largestRectangleArea(heights));
        System.out.println(solution.largestRectangleArea1(heights));
    }

    public int largestRectangleArea1(int[] heights) {
        int N = heights.length;
        int[] newHeights = new int[N + 2];
        for (int i = 0; i < N; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        N += 2;

        int area = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < N; i++) {
            while (heights[stack.getFirst()] > heights[i]) {
                int height = heights[stack.removeFirst()];
                int width = i - stack.getFirst() - 1;
                area = Math.max(area, height * width);
            }
            stack.addFirst(i);
        }
        return area;
    }


    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i;
            int right = i;

            for (int j = i; j >= 0; j--) {
                if (heights[j] >= height) {
                    left = j;
                } else {
                    break;
                }
            }

            for (int j = i; j < heights.length; j++) {
                if (heights[j] >= height) {
                    right = j;
                } else {
                    break;
                }
            }

            int area = height * (right - left + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
