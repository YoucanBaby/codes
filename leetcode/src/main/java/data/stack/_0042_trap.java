package data.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 00:45
 * @Description:
 */
public class _0042_trap {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        _0042_trap solution = new _0042_trap();

        System.out.println(solution.trap(height));
        System.out.println(solution.trap2(height));
        System.out.println(solution.trap4(height));
    }

    public int trap4(int[] height) {
        // 双指针
        int left = 0;
        int right = height .length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ret = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                ret += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                ret += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ret;
    }

    public int trap3(int[] height) {
        // 栈，我放弃了
        Deque<Integer> stack = new LinkedList<>();
        int ret = 0;
        int N = height.length;

        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty() && height[i] > stack.getFirst()) {
                int top = stack.getFirst();

            }
            stack.addFirst(i);
        }
        return 0;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        // 动态规划
        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        leftMax[0] = height[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ret = 0;
        for (int i = 1; i < N - 1; i++) {
            ret = ret + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ret;
    }

    public int trap(int[] height) {
        int N = height.length;
        int ret = 0;

        for (int i = 0; i < N; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < N; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ret += Math.min(leftMax, rightMax) - height[i];
        }
        return ret;
    }
}
