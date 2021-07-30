package algorithm;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 07:58
 * @Description:
 */
public class _10_11_wiggleSort {


    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 0 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            if ((i & 1) == 1 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
