package data.stack;

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
        Deque<Integer> stack = new LinkedList<>();
        int N = nums.length;
        int[] ret = new int[N];
        Arrays.fill(ret, -1);

        for (int i = 0; i < 2 * N - 1; i++) {
            while (!stack.isEmpty() && nums[i % N] > nums[stack.getFirst()]) {
                ret[stack.removeFirst()] = nums[i % N];
            }
            stack.addFirst(i % N);
        }
        return ret;
    }
}
