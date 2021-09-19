package data.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.queue
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 14:50
 * @Description:
 */
public class _0995_minKBitFlips {

    public static void main(String[] args) {
        _0995_minKBitFlips solution = new _0995_minKBitFlips();

        int[] nums = {0,0,0,1,0,1,1,0};
        System.out.println(solution.minKBitFlips(nums, 3));
    }

    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i > deque.peek() + k - 1) {
                deque.poll();
            }
            // 1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            // 2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (deque.size() % 2 == nums[i]) {
                if (i + k > nums.length) return -1;
                deque.offer(i);
                res++;
            }
        }
        return res;
    }
}
