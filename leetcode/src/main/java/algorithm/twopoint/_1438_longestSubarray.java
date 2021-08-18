package algorithm.twopoint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 10:58
 * @Description:
 */
public class _1438_longestSubarray {


    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int res = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && maxDeque.getLast() < nums[right]) {
                maxDeque.removeLast();
            }
            while (!minDeque.isEmpty() && minDeque.getLast() > nums[right]) {
                minDeque.removeLast();
            }
            maxDeque.addLast(nums[right]);
            minDeque.addLast(nums[right]);
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    maxDeque.getFirst() - minDeque.getFirst() > limit) {
                if (nums[left] == maxDeque.getFirst()) {
                    maxDeque.removeFirst();
                }
                if (nums[left] == minDeque.getFirst()) {
                    minDeque.removeFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
