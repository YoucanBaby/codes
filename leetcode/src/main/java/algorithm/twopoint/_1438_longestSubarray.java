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
        int res = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.getLast()) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[right]);

            while (!minDeque.isEmpty() && nums[right] < minDeque.getLast()) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[right]);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    maxDeque.getFirst() - minDeque.getFirst() > limit) {
                if (maxDeque.getFirst() == nums[left]) {
                    maxDeque.removeFirst();
                }
                if (minDeque.getFirst() == nums[left]) {
                    minDeque.removeFirst();
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
