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
        deque.addFirst(0);
        int ret = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            // 队内前缀和下标对应的值需要严格单调递增
            while (!deque.isEmpty() && preSum[deque.getLast() ]>= preSum[i]) {
                deque.removeLast();
            }
            // 当前元素和队首的差值 >= k 时，记录最小长度，删除队首
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= k) {
                ret = Math.min(ret, i - deque.getFirst());
                deque.removeFirst();
            }
            deque.addLast(i);
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ret;
        }
    }
}
