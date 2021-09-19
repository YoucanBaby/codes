package data.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-17 13:58
 * @Description:
 */
public class _0862_shortestSubarray {

    public static void main(String[] args) {
        int[] nums = {84,-37,32,40,95};
        int k = 167;
        _0862_shortestSubarray solution = new _0862_shortestSubarray();

        System.out.println(solution.shortestSubarray(nums, k));
    }


    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
