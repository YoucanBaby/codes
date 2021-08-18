package algorithm.twopoint;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-15 00:45
 * @Description:
 */
public class _0042_trap {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        _0042_trap solution = new _0042_trap();

        System.out.println(solution.trap(height));
    }

    public int trap(int[] nums) {
        int leftMax = 0;            // 左侧最大高度
        int rightMax = 0;           // 右侧最大高度

        int res = 0;
        int left = 0;
        int right = nums .length - 1;
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - nums[left]);
                leftMax = Math.max(leftMax, nums[left]);
                left++;
            } else {
                res += Math.max(0, rightMax - nums[right]);
                rightMax = Math.max(rightMax, nums[right]);
                right--;
            }
        }
        return res;
    }

}
