package data.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 21:20
 * @Description:
 */
public class _0503_nextGreaterElements {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        _0503_nextGreaterElements solution = new _0503_nextGreaterElements();

        int[] res = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * N; i++) {
            while (!stack.isEmpty() && nums[i % N] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % N];
            }
            stack.push(i % N);
        }
        return res;
    }
}
