package algorithm;

import java.util.Arrays;

/**
 * @BelongsProject: interview
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 17:04
 * @Description:
 */
public class _16_16_subSort {

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        _16_16_subSort solution = new _16_16_subSort();

        System.out.println(Arrays.toString(solution.subSort(nums)));
    }

    public int[] subSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int right = -1;
        int left = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int N = nums.length;

        // 从左向右遍历，如果右边的值小于左边的最大值，就更新右边界
        for (int i = 0; i < N; i++) {
            if (nums[i] < max) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }
        // 从右向左遍历，如果左边的值大于右边的最小值，就更新左边界
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return new int[] {left, right};
    }
}
