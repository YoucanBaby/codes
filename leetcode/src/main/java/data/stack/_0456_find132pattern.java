package data.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 00:54
 * @Description:
 */
public class _0456_find132pattern {

    public static void main(String[] args) {
        int[] nums = {3,5,2,1,0,3,4};
        _0456_find132pattern solution = new _0456_find132pattern();

        System.out.println(solution.find132pattern(nums));
    }

    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int maxJ = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maxJ) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                maxJ = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
