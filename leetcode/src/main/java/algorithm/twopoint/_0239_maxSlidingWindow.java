package algorithm.twopoint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-16 14:05
 * @Description:
 */
public class _0239_maxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        int N = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();      // 保证队首是最大值，队尾是最小值
        int[] res = new int[N - k + 1];

        for (int right = 0; right < N; right++) {
            int left = right - k + 1;
            // 删除不在窗口内的元素
            if (!deque.isEmpty() && deque.getFirst() <= left - 1) {
                deque.removeFirst();
            }
            // 弹出前面小的数，保证队首最大，队尾最小
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[right]) {
                deque.removeLast();
            }
            deque.addLast(right);
            // 窗口形成之后（即窗口长度为k之后），保存窗口的最大值
            if (left >= 0) {
                res[left] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
