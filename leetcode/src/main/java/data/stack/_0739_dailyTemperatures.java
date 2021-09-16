package data.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 22:33
 * @Description:
 */
public class _0739_dailyTemperatures {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        _0739_dailyTemperatures solution = new _0739_dailyTemperatures();

        int[] res2 = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res2));
    }


    public int[] dailyTemperatures(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
