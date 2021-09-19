package data.queue;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.queue
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 04:28
 * @Description:
 */
public class _0950_deckRevealedIncreasing {

    public int[] deckRevealedIncreasing(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            deque.offer(nums[i]);
            if (i != 0) {
                deque.offer(deque.poll());
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = deque.removeLast();
        }
        return res;
    }
}
