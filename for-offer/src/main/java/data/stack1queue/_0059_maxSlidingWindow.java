package data.stack1queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 13:21
 * @Description:
 */
public class _0059_maxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        _0059_maxSlidingWindow solution = new _0059_maxSlidingWindow();

        int[] ret1 = solution.maxSlidingWindow1(nums, k);
        System.out.println(Arrays.toString(ret1));

        int[] ret = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ret));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;

        Deque<Integer> deque = new ArrayDeque<>();
        int N = nums.length;
        int[] ret = new int[N - k + 1];

        for (int j = 0; j < N; j++) {
            int i = j - k + 1;
            if (i - 1 >= 0 && deque.getFirst() == i - 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(j);
            if (i >= 0) {
                ret[i] = nums[deque.getFirst()];
            }
        }
        return ret;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        int N = nums.length;
        int[] ret = new int[N - k + 1];

        for (int i = 0; i <  N - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ret[i] = max;
        }
        return ret;
    }
}
