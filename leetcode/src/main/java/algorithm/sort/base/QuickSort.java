package algorithm.sort.base;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort.base
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 10:45
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {101,51,7,98,154,23,4};
        QuickSort solution = new QuickSort();
        solution.quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        int p1 = left;
        int p2 = right;
        // 选最后一位做为基准数
        int pivot = nums[right];
        while (p1 < p2) {
            // 先从左向右找大于基准的数
            while (p1 < p2 && nums[p1] <= pivot) {
                p1++;
            }
            // 再从右向左找小于基准的数
            while (p1 < p2 && pivot <= nums[p2]) {
                p2--;
            }
            // 交换这这两个数
            swap(nums, p1, p2);
        }
        // 基准数归位，p1是基准数的位置
        swap(nums, p1, right);
        // 递归左边数组
        quickSort(nums, left, p1 - 1);
        // 递归右边数组
        quickSort(nums, p1 + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
