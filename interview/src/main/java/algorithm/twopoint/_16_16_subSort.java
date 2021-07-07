package algorithm.twopoint;

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

        int end = -1;
        int start = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int N = nums.length;

        // 从左向右遍历
        for(int i = 0; i < N; i++){
            // 如果右边的值小于左边的最大值，就更新end；反之，更新max
            if(nums[i] < max){
                end = i;
            }else{
                max = nums[i];
            }
        }

        // 从右向左遍历
        for (int i = N - 1; i >= 0; i--) {
            // 如果左边的值大于右边的最小值，就更新start；反之，更新min
            if(nums[i] > min){
                start = i;
            }else{
                min = nums[i];
            }
        }

        return new int[] {start, end};
    }
}
